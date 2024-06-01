package com.widedelivery.order.service;

import com.widedelivery.order.entity.OrderMatchingModel;

import java.util.List;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public final class OrderConsumingTask implements Runnable {
    private static final String MESSAGE_OF_ORDERS_ARE_CONSUMED = "[CONSUMED %d] %s.\n";
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING = 20;

    private final OrderMatchingProcessor orderMatchingProcessor;

    public OrderConsumingTask(OrderMatchingProcessor orderMatchingProcessor) {
        this.orderMatchingProcessor = orderMatchingProcessor;
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_CONSUMING);
                final List<OrderMatchingModel> consumedOrders = this.orderMatchingProcessor.getMatchedOrders();
                out.printf(MESSAGE_OF_ORDERS_ARE_CONSUMED, consumedOrders.size(), consumedOrders);
            }
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
        }
    }
}
