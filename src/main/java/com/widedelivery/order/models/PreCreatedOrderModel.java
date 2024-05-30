package com.widedelivery.order.models;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.proto.CreateOrderInput;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PreCreatedOrderModel {

    private String userId;

    private boolean mayBeLoader;

    private int searchRadius;

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

    private String description;

    private boolean needLoader;

    private String paymentMethod;

    public static PreCreatedOrderModel getFromGrpcRequest(CreateOrderInput createOrderInput) {
        PreCreatedOrderModel newOrder = new PreCreatedOrderModel();
        newOrder.setUserId(createOrderInput.getUser().getId());
//        newOrder.setCargoType(createOrderInput.getCargoType()); // TODO define on client api side
        newOrder.setCargoLength(createOrderInput.getCargoLength());
        newOrder.setCargoWidth(createOrderInput.getCargoWidth());
        newOrder.setCargoHeight(createOrderInput.getCargoHeight());
        newOrder.setCargoWeight(createOrderInput.getCargoWeight());
        newOrder.setDepartureLongitude(createOrderInput.getDepartureLongitude());
        newOrder.setDepartureLatitude(createOrderInput.getDepartureLatitude());
        newOrder.setDepartureTime(createOrderInput.getDepartureTime());
        newOrder.setDestinationLongitude(createOrderInput.getDestinationLongitude());
        newOrder.setDestinationLatitude(createOrderInput.getDestinationLatitude());
        newOrder.setDestinationTime(createOrderInput.getDestinationTime());
        newOrder.setDescription(createOrderInput.getDescription());
        newOrder.setNeedLoader(createOrderInput.getNeedLoader());
        newOrder.setPaymentMethod(createOrderInput.getPaymentMethod());
        return newOrder;
    }
}
