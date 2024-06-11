package com.widedelivery.order.entity;

import com.google.protobuf.Timestamp;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PreCreatedOrderModel {

    private String userId;

    private boolean mayBeLoader;

    private int searchRadius;

    private double cargoLength;

    private double cargoWidth;

    private double cargoHeight;

    private double cargoWeight;

    private String cargoType;

    private String departureLongitude;

    private String departureLatitude;

    private Timestamp departureTime;

    private String destinationLongitude;

    private String destinationLatitude;

    private Timestamp destinationTime;

    private String description;

    private boolean needLoader;

    private String paymentMethod;
}
