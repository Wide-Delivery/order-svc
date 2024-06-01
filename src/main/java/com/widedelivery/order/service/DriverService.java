package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;

import java.util.Queue;

public interface DriverService {

    boolean addDriverToMatching(String driverId);

    boolean removeDriverFromMatching(String driverId);

    Queue<OrderModel> getMatchedOrdersForDrivers();
}
