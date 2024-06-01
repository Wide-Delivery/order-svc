package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderModel;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class DriverServiceImpl implements DriverService{

    @Override
    public boolean addDriverToMatching(String driverId) {
        return false;
    }

    @Override
    public boolean removeDriverFromMatching(String driverId) {
        return false;
    }

    @Override
    public Queue<OrderModel> getMatchedOrdersForDrivers() {
        return null;
    }
}
