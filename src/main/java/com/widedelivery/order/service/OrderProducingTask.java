package com.widedelivery.order.services;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.models.OrderMatchingModel;
import com.widedelivery.order.models.OrderStatus;
import com.widedelivery.utils.GeoLocationUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class OrderProducingTask implements Runnable {

    private static final String MESSAGE_OF_ORDER_IS_PRODUCED = "[PRODUCED ORDER] %s.\n";
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 3;

    private final OrderMatchingProcessor orderMatchingProcessor;
    private final OrderFactory orderFactory;

    public OrderProducingTask(OrderMatchingProcessor orderMatchingProcessor) {
        this.orderMatchingProcessor = orderMatchingProcessor;
        this.orderFactory = new OrderFactory();
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                final OrderMatchingModel producedOrder = this.orderFactory.create();
                SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);
                this.orderMatchingProcessor.addOrderForMatching(producedOrder);
                out.printf(MESSAGE_OF_ORDER_IS_PRODUCED, producedOrder);
            }
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
        }

    }

    private static final class OrderFactory {
        private static final int INITIAL_ORDER_INDEX = 1;

        private int nextOrderIndex;

        public OrderFactory() {
            this.nextOrderIndex = INITIAL_ORDER_INDEX;
        }

        public OrderMatchingModel create() {
            return new OrderMatchingModel(
                    String.format("order-%d", nextOrderIndex++),
                    OrderStatus.MATCHING_DRIVER,
                    (Math.random()*100+1),
                    (Math.random()*75+1),
                    (Math.random()*20+1),
                    new Random().nextDouble(),
                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                    Timestamp.getDefaultInstance(),
                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                    Timestamp.getDefaultInstance(),
                    new Random().nextBoolean()
                );
        }
    }
}
