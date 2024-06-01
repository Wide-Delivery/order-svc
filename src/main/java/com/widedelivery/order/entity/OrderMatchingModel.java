package com.widedelivery.order.entity;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.proto.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.lang.System.out;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderMatchingModel {

    private String orderId;

    private OrderStatus status;

    private double cargoLength;

    private double cargoWidth;

    private double cargoHeight;

    private double cargoWeight;

    private String departureLongitude;

    private String departureLatitude;

    private Timestamp departureTime;

    private String destinationLongitude;

    private String destinationLatitude;

    private Timestamp destinationTime;

    private boolean needLoader;

    public static OrderMatchingModel parseFromGrpcMessage(Order orderFromGrpc) {
        OrderMatchingModel order = new OrderMatchingModel();
        order.setOrderId(orderFromGrpc.getId());
        order.setStatus(OrderStatus.valueOf(orderFromGrpc.getStatus().name()));
        order.setCargoLength(orderFromGrpc.getCargoLength());
        order.setCargoHeight(orderFromGrpc.getCargoHeight());
        order.setCargoWidth(orderFromGrpc.getCargoWidth());
        order.setCargoWeight(orderFromGrpc.getCargoWeight());
        order.setDepartureLatitude(orderFromGrpc.getDepartureLatitude());
        order.setDepartureLongitude(orderFromGrpc.getDepartureLongitude());
        order.setDepartureTime(orderFromGrpc.getDepartureTime());
        order.setDestinationLatitude(orderFromGrpc.getDestinationLatitude());
        order.setDestinationLongitude(orderFromGrpc.getDestinationLongitude());
        order.setDestinationTime(orderFromGrpc.getDestinationTime());
        order.setNeedLoader(orderFromGrpc.getNeedLoader());
        return order;
    }

    @Override
    public String toString() {
        return "OrderMatchingModel{" +
                "orderId='" + orderId + '\'' +
                ", status=" + status +
                ", cargoLength=" + String.format("%.2f", cargoLength) +
                ", cargoWidth=" + String.format("%.2f", cargoWidth) +
                ", cargoHeight=" + String.format("%.2f", cargoHeight) +
                ", cargoWeight=" + String.format("%.2f", cargoWeight) +
                ", departureLongitude='" + departureLongitude + '\'' +
                ", departureLatitude='" + departureLatitude + '\'' +
                ", departureTime=" + departureTime +
                ", destinationLongitude='" + destinationLongitude + '\'' +
                ", destinationLatitude='" + destinationLatitude + '\'' +
                ", destinationTime=" + destinationTime +
                ", needLoader=" + needLoader +
                '}';
    }
}
