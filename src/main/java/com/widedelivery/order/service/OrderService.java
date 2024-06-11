package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.OrderStatus;
import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.entity.TruckType;
import com.widedelivery.order.exception.OrderNotFoundException;
import com.widedelivery.order.mapper.OrderMapper;
import com.widedelivery.order.repository.CustomOrderRepository;
import com.widedelivery.order.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private static final int BASE_PRICE = 30;

    private final OrderRepository orderRepository;
    private final CustomOrderRepository customOrderRepository;

    private final PriceEstimationService priceEstimationService;

    private final Map<TruckType, Double> truckTypePriceMap = Map.of(
            TruckType.SMALL, 1.0,
            TruckType.MEDIUM, 1.3,
            TruckType.LARGE, 1.5
    );

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        CustomOrderRepository customOrderRepository,
                        PriceEstimationService priceEstimationService) {
        this.orderRepository = orderRepository;
        this.customOrderRepository = customOrderRepository;
        this.priceEstimationService = priceEstimationService;
    }

    private TruckType defineOrderType(OrderModel order) {
        double freeSpaceLength = order.getCargoLength();
        double freeSpaceWidth = order.getCargoWidth();
        double freeSpaceHeight = order.getCargoHeight();

        int smallCount = 0;
        int mediumCount = 0;

        // Check for SMALL criteria
        if (freeSpaceLength <= 120) smallCount++;
        if (freeSpaceWidth <= 50) smallCount++;
        if (freeSpaceHeight <= 20) smallCount++;

        // Check for MEDIUM criteria
        if (freeSpaceLength <= 250) mediumCount++;
        if (freeSpaceWidth <= 150) mediumCount++;
        if (freeSpaceHeight <= 150) mediumCount++;

        // Determine the truck type based on the counts
        if (smallCount == 3) {
            return TruckType.SMALL;
        } else if (smallCount > 0) {
            return TruckType.MEDIUM;
        } else if (mediumCount == 3) {
            return TruckType.MEDIUM;
        } else {
            return TruckType.LARGE;
        }
    }

    private double defineOrderPrice(OrderModel order) {
        TruckType orderType = defineOrderType(order);
        double truckPricePerKm = truckTypePriceMap.get(orderType);
        String distance = order.getDistance();
        if (distance == null || distance.equals("")) {
            distance = "100 km";
        }
        double volumePrice = order.getCargoLength() * order.getCargoWidth() * order.getCargoHeight() / 4000;
        return priceEstimationService.calculatePrice(order, BASE_PRICE, truckPricePerKm, Double.parseDouble(distance.split(" ")[0]), volumePrice);
    }

    public OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel) {
        OrderModel order = OrderMapper.getFromPreCreateModel(preCreatedOrderModel);
        fillOrderDimensionsIfTypeSelected(order);
        double price = defineOrderPrice(order);
        order.setPrice(price);
        return orderRepository.save(order);
    }

    public OrderModel getOrder(String orderId) {
        return orderRepository.findById(new ObjectId(orderId))
                .orElseThrow(
                        () -> {
                            logger.error("Order not found with id: {}", orderId);
                            return new OrderNotFoundException("Order not found with id: " + orderId);
                        }
                );
    }

    private void fillOrderDimensionsIfTypeSelected(OrderModel order) {
        if (order.getCargoType() == null) {
            return;
        }
        if (order.getCargoType().equals("SMALL")) {
            order.setCargoLength(120);
            order.setCargoWidth(50);
            order.setCargoHeight(20);
        }
        if (order.getCargoType().equals("MEDIUM")) {
            order.setCargoLength(250);
            order.setCargoWidth(150);
            order.setCargoHeight(150);
        }
        if (order.getCargoType().equals("LARGE")) {
            order.setCargoLength(750);
            order.setCargoWidth(220);
            order.setCargoHeight(200);
        }
    }

    public Page<OrderModel> getOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        return orderRepository.findAll(pageable);
    }

    public Page<OrderModel> searchOrders(Map<String, Object> searchParams, Pageable pageable) {
        return customOrderRepository.searchOrders(searchParams, pageable);
    }

    public OrderModel linkDriverWithOrder(String orderId, String driverId) {
        OrderModel order = getOrder(orderId);
        if (order.getDriverId() != null && !order.getDriverId().equals("")) {
            throw new IllegalStateException("Order already has a driver linked!");
        }
        order.setDriverId(driverId);
        order.setStatus(OrderStatus.READY);
        return orderRepository.save(order);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(new ObjectId(orderId));
    }

    public OrderModel updateOrder(String orderId, PreCreatedOrderModel preCreatedOrderModel) {
        OrderModel order = getOrder(orderId);
        var updatedOrder = OrderMapper.getFromPreCreateModel(preCreatedOrderModel);
        updatedOrder.setId(order.getId());

        return orderRepository.save(updatedOrder);
    }
}
