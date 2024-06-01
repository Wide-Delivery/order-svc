package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.exception.OrderNotFoundException;
import com.widedelivery.order.mapper.OrderMapper;
import com.widedelivery.order.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel) {
        return orderRepository.save(OrderMapper.getFromPreCreateModel(preCreatedOrderModel));
    }

    @Override
    public OrderModel getOrder(String orderId) {
        return orderRepository.findById(new ObjectId(orderId))
                .orElseThrow(
                        () -> {
                            logger.error("Order not found with id: {}", orderId);
                            return new OrderNotFoundException("Order not found with id: " + orderId);
                        }
                );
    }
}
