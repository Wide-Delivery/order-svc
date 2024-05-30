package com.widedelivery.order.models;

public enum OrderStatus {
    CREATED,
    NEED_PAYMENT,
    MATCHING_DRIVER,
    CANNOT_MATCH_DRIVER,
    READY,
    DRIVER_MOVES_TO_PICKUP,
    WAIT_FOR_PICKUP,
    PICKUP,
    TRANSPORTATION,
    UNLOADING,
    COMPLETED,
    CANCELLED,
}
