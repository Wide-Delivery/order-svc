package com.widedelivery.order.services;

import com.widedelivery.order.models.DriverDto;
import com.widedelivery.order.models.DriverTripDto;
import com.widedelivery.order.models.OrderMatchingModel;
import com.widedelivery.utils.GeoLocationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;

//@Component
public final class OrderMatchingProcessor {
    private static final Logger log = LoggerFactory.getLogger(OrderMatchingProcessor.class);
    private final Map<OrderMatchingModel, Boolean> ordersForMatching;
    private final List<DriverDto> driversForMatching;
    private final int maxStoredOrders;
    private final int maxStoredDrivers;

    public OrderMatchingProcessor(final int maxStoredOrders, final int maxStoredDrivers) {
        this.ordersForMatching = new HashMap<>(maxStoredOrders);
        this.driversForMatching = new ArrayList<>(maxStoredDrivers);
        this.maxStoredOrders = maxStoredOrders;
        this.maxStoredDrivers = maxStoredDrivers;
    }

    public synchronized void addDriverForMatching(final DriverDto driver) {
        try {
            while (this.ordersForMatching.size() >= this.maxStoredDrivers) {
                super.wait();
            }
            this.driversForMatching.add(driver);
            super.notifyAll();
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
        }
    }

    public synchronized void addOrderForMatching(final OrderMatchingModel order) {
        try {
            while (this.ordersForMatching.size() >= this.maxStoredOrders) {
                super.wait();
            }
            this.ordersForMatching.put(order, true);
            super.notifyAll();
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
        }

    }

    public synchronized List<OrderMatchingModel> getMatchedOrders() {
        try {
            while (this.ordersForMatching.isEmpty()) {
                super.wait();
            }
            for (final DriverDto driver : this.driversForMatching) {
               for (final OrderMatchingModel order : this.ordersForMatching.keySet()) {
                   for (final DriverTripDto trip : driver.getTrips()) {
                       double koeff = GeoLocationUtils.calculateCoeff(order, trip);
                       out.printf("Koeff: %f\n", koeff);
                   }
               }
            }

            List<OrderMatchingModel> matchedOrders = ordersForMatching.entrySet().stream()
                    .filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey)
                    .toList();
            ordersForMatching.entrySet().removeIf(Map.Entry::getValue);
            super.notifyAll();
            return matchedOrders;
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
            throw new RuntimeException(new InterruptedException());
        }
    }

}
