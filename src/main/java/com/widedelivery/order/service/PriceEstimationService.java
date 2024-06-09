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
    public double calculatePrice(OrderModel order, double basePrice, double pricePerKm, double distance) {
//        double demandCoefficient = calculateDemandCoefficient(order.getDepartureTime(), order.getDepartureLongitude(), order.getDepartureLatitude());
//        double locationCoefficient = calculateLocationCoefficient(order.getDepartureLongitude(), order.getDepartureLatitude(), order.getDestinationLongitude(), order.getDestinationLatitude());
//        double roadConditionCoefficient = calculateRoadConditionCoefficient(order.getDepartureLongitude(), order.getDepartureLatitude(), order.getDestinationLongitude(), order.getDestinationLatitude());
//        double timeOfDayCoefficient = calculateTimeOfDayCoefficient(order.getDepartureTime());
//        double holidayCoefficient = calculateHolidayCoefficient(order.getDepartureTime());
//
//        return basePrice + (pricePerKm * distance * demandCoefficient * locationCoefficient * roadConditionCoefficient * timeOfDayCoefficient * holidayCoefficient);
        return new Random().nextDouble();
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
