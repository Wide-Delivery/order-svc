package com.widedelivery.order.repository;

import com.widedelivery.order.entity.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface CustomOrderRepository {
    Page<OrderModel> searchOrders(Map<String, Object> searchParams, Pageable pageable);
}
