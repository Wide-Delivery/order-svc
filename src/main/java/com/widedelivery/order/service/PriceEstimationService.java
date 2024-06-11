package com.widedelivery.order.service;


import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public final class PriceEstimationService {
    @Autowired
    private OrderRepository orderRepository;

    // Визначення ціни за поїздку
    public double calculatePrice(OrderModel order, double basePrice, double pricePerKm, double distance, double volumePrice) {
        return basePrice + pricePerKm * distance + volumePrice * pricePerKm;
    }

    // Методи для розрахунку коефіцієнтів (приклади)
    private double calculateDemandCoefficient(Instant time, double longitude, double latitude) {
        // Припустимо, розрахунок виконується тут
        return 1.0;
    }

    private double calculateLocationCoefficient(double depLong, double depLat, double destLong, double destLat) {
        // Припустимо, розрахунок виконується тут
        return 1.0;
    }
}
