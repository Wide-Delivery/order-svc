package com.widedelivery.order.services;

import com.widedelivery.order.models.OrderModel;
import com.widedelivery.order.models.PreCreatedOrderModel;

public interface OrderService  {
    OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel);
    OrderModel getOrder(String orderId);
}
