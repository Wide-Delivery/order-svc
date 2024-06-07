package com.widedelivery.order.mapper;

import java.util.Optional;

@lombok.experimental.UtilityClass
public class OrderMapper {

    public static com.widedelivery.order.proto.Order toGrpcModel(final com.widedelivery.order.entity.OrderModel order) {
        var messageBuilder = com.widedelivery.order.proto.Order.newBuilder()
                .setId(order.getId().toString())
                .setUserId(order.getUserId().toString())
                .setCargoLength(order.getCargoLength())
                .setCargoWidth(order.getCargoWidth())
                .setCargoWeight(order.getCargoWeight())
                .setCargoHeight(order.getCargoHeight())
                .setStatus(convertToOrderStatus(order.getStatus()))
                .setDepartureLongitude(order.getDepartureLongitude())
                .setDepartureLatitude(order.getDepartureLatitude())
                .setDestinationLongitude(order.getDestinationLongitude())
                .setDestinationLatitude(order.getDestinationLatitude())
                .setDescription(order.getDescription())
                .setNeedLoader(order.isNeedLoader())
                .setPaymentMethod(order.getPaymentMethod())
                .setCreatedAt(convertToTimestamp(order.getCreatedAt()))
                .setUpdatedAt(convertToTimestamp(order.getUpdatedAt()));

        Optional.ofNullable(order.getDriverId())
                .ifPresent(messageBuilder::setDriverId);

        Optional.ofNullable(order.getDestinationTime())
                .ifPresent(time -> messageBuilder.setDestinationTime(convertToTimestamp(time)));

        Optional.ofNullable(order.getDepartureTime())
                .ifPresent(time -> messageBuilder.setDepartureTime(convertToTimestamp(time)));

        return messageBuilder.build();
    }

    public static com.widedelivery.order.entity.OrderModel getFromPreCreateModel(com.widedelivery.order.entity.PreCreatedOrderModel preCreatedOrderModel) {
        com.widedelivery.order.entity.OrderModel orderModel = new com.widedelivery.order.entity.OrderModel();
        orderModel.setUserId(new org.bson.types.ObjectId(preCreatedOrderModel.getUserId()));
        orderModel.setCargoLength(preCreatedOrderModel.getCargoLength());
        orderModel.setCargoWidth(preCreatedOrderModel.getCargoWidth());
        orderModel.setCargoHeight(preCreatedOrderModel.getCargoHeight());
        orderModel.setCargoWeight(preCreatedOrderModel.getCargoWeight());
        orderModel.setDepartureLongitude(preCreatedOrderModel.getDepartureLongitude());
        orderModel.setDepartureLatitude(preCreatedOrderModel.getDepartureLatitude());
        orderModel.setDepartureTime(convertToInstant(preCreatedOrderModel.getDepartureTime()));
        orderModel.setDestinationLongitude(preCreatedOrderModel.getDestinationLongitude());
        orderModel.setDestinationLatitude(preCreatedOrderModel.getDestinationLatitude());
        orderModel.setDestinationTime(convertToInstant(preCreatedOrderModel.getDestinationTime()));
        orderModel.setDescription(preCreatedOrderModel.getDescription());
        orderModel.setNeedLoader(preCreatedOrderModel.isNeedLoader());
        orderModel.setPaymentMethod(preCreatedOrderModel.getPaymentMethod());
        return orderModel;
    }

    private static com.widedelivery.order.entity.OrderStatus convertToOrderStatus(com.widedelivery.order.proto.OrderStatus status) {
        return switch (status) {
            case CREATED -> com.widedelivery.order.entity.OrderStatus.CREATED;
            case NEED_PAYMENT -> com.widedelivery.order.entity.OrderStatus.NEED_PAYMENT;
            case MATCHING_DRIVER -> com.widedelivery.order.entity.OrderStatus.MATCHING_DRIVER;
            case CANNOT_MATCH_DRIVER -> com.widedelivery.order.entity.OrderStatus.CANNOT_MATCH_DRIVER;
            case READY -> com.widedelivery.order.entity.OrderStatus.READY;
            case DRIVER_MOVES_TO_PICKUP -> com.widedelivery.order.entity.OrderStatus.DRIVER_MOVES_TO_PICKUP;
            case WAIT_FOR_PICKUP -> com.widedelivery.order.entity.OrderStatus.WAIT_FOR_PICKUP;
            case PICKUP -> com.widedelivery.order.entity.OrderStatus.PICKUP;
            case TRANSPORTATION -> com.widedelivery.order.entity.OrderStatus.TRANSPORTATION;
            case UNLOADING -> com.widedelivery.order.entity.OrderStatus.UNLOADING;
            case COMPLETED -> com.widedelivery.order.entity.OrderStatus.COMPLETED;
            case CANCELLED -> com.widedelivery.order.entity.OrderStatus.CANCELLED;
            case UNRECOGNIZED -> throw new IllegalArgumentException("Unknown order status: " + status);
        };
    }

    private static com.widedelivery.order.proto.OrderStatus convertToOrderStatus(com.widedelivery.order.entity.OrderStatus status) {
        return switch (status) {
            case CREATED -> com.widedelivery.order.proto.OrderStatus.CREATED;
            case NEED_PAYMENT -> com.widedelivery.order.proto.OrderStatus.NEED_PAYMENT;
            case MATCHING_DRIVER -> com.widedelivery.order.proto.OrderStatus.MATCHING_DRIVER;
            case CANNOT_MATCH_DRIVER -> com.widedelivery.order.proto.OrderStatus.CANNOT_MATCH_DRIVER;
            case READY -> com.widedelivery.order.proto.OrderStatus.READY;
            case DRIVER_MOVES_TO_PICKUP -> com.widedelivery.order.proto.OrderStatus.DRIVER_MOVES_TO_PICKUP;
            case WAIT_FOR_PICKUP -> com.widedelivery.order.proto.OrderStatus.WAIT_FOR_PICKUP;
            case PICKUP -> com.widedelivery.order.proto.OrderStatus.PICKUP;
            case TRANSPORTATION -> com.widedelivery.order.proto.OrderStatus.TRANSPORTATION;
            case UNLOADING -> com.widedelivery.order.proto.OrderStatus.UNLOADING;
            case COMPLETED -> com.widedelivery.order.proto.OrderStatus.COMPLETED;
            case CANCELLED -> com.widedelivery.order.proto.OrderStatus.CANCELLED;
        };
    }

    private static com.google.protobuf.Timestamp convertToTimestamp(java.time.Instant instant) {
        return com.google.protobuf.Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).setNanos(instant.getNano()).build();
    }

    private static java.time.Instant convertToInstant(com.google.protobuf.Timestamp timestamp) {
        return java.time.Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
    }
}
