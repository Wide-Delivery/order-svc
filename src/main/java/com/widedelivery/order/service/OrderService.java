package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.OrderStatus;
import com.widedelivery.order.entity.PreCreatedOrderModel;
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

    private final OrderRepository orderRepository;
    private final CustomOrderRepository customOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomOrderRepository customOrderRepository) {
        this.orderRepository = orderRepository;
        this.customOrderRepository = customOrderRepository;
    }

    public OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel) {
        return orderRepository.save(OrderMapper.getFromPreCreateModel(preCreatedOrderModel));
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
