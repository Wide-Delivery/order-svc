package com.widedelivery.order.services;

public class Runner {
    public static void main(String[] args) {
        final int processorMaxStoredOrders = 10;
        final int processorMaxStoredDrivers = 5;
        final OrderMatchingProcessor orderMatchingProcessor = new OrderMatchingProcessor(processorMaxStoredOrders, processorMaxStoredDrivers);

        final Thread producingThread = new Thread(new OrderProducingTask(orderMatchingProcessor));
        final Thread driverProducingThread = new Thread(new DriverProducingTask(orderMatchingProcessor));
        final Thread consumingThread = new Thread(new OrderConsumingTask(orderMatchingProcessor));

        producingThread.start();
        driverProducingThread.start();
        consumingThread.start();
    }
}
