package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.PreCreatedOrderModel;

public interface OrderService  {

    OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel);

    OrderModel getOrder(String orderId);
}
