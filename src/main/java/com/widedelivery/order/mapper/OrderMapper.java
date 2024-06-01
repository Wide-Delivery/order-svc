package com.widedelivery.order.mapper;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.proto.Order;
import lombok.experimental.UtilityClass;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.Optional;

@UtilityClass
public class OrderMapper {

    public static Order toGrpcModel(final OrderModel order) {
        var messageBuilder = Order.newBuilder()
                .setId(order.getId().toString())
                .setUserId(order.getUserId().toString())
                .setCargoLength(order.getCargoLength())
                .setCargoWidth(order.getCargoWidth())
                .setCargoHeight(order.getCargoHeight())
                .setDepartureLongitude(order.getDepartureLongitude())
                .setDepartureLatitude(order.getDepartureLatitude())
                .setDestinationLongitude(order.getDestinationLongitude())
                .setDestinationLatitude(order.getDestinationLatitude())
                .setDescription(order.getDescription())
                .setNeedLoader(order.isNeedLoader())
                .setPaymentMethod(order.getPaymentMethod())
                .setCreatedAt(convertToTimestamp(order.getCreatedAt()))
                .setUpdatedAt(convertToTimestamp(order.getUpdatedAt()));

        Optional.ofNullable(order.getDestinationTime())
                .ifPresent(time -> messageBuilder.setDestinationTime(convertToTimestamp(time)));

        Optional.ofNullable(order.getDepartureTime())
                .ifPresent(time -> messageBuilder.setDepartureTime(convertToTimestamp(time)));

        return messageBuilder.build();
    }

    public static OrderModel getFromPreCreateModel(PreCreatedOrderModel preCreatedOrderModel) {
        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(new ObjectId(preCreatedOrderModel.getUserId()));
        orderModel.setCargoLength(preCreatedOrderModel.getCargoLength());
        orderModel.setCargoWidth(preCreatedOrderModel.getCargoWidth());
        orderModel.setCargoHeight(preCreatedOrderModel.getCargoHeight());
        orderModel.setCargoWidth(preCreatedOrderModel.getCargoWeight());
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

    private static Timestamp convertToTimestamp(Instant instant) {
        return Timestamp.newBuilder().setSeconds(instant.getEpochSecond()).build();
    }

    private static Instant convertToInstant(Timestamp timestamp) {
        return Instant.ofEpochSecond(timestamp.getSeconds());
    }
}
