package com.widedelivery.order.services;

import com.widedelivery.order.models.OrderModel;
import com.widedelivery.order.models.PreCreatedOrderModel;

import java.util.List;
import java.util.Queue;

public interface DriverService {
    boolean addDriverToMatching(String driverId);
    boolean removeDriverFromMatching(String driverId);
    Queue<OrderModel> getMatchedOrdersForDrivers();
}
