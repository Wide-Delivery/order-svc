package com.widedelivery.order.services;

import com.widedelivery.order.models.OrderModel;
import com.widedelivery.order.models.PreCreatedOrderModel;
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
