package com.widedelivery.order.mapper;

import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.proto.CreateOrderInput;
import lombok.experimental.UtilityClass;
import lombok.NonNull;

@UtilityClass
public class PreCreatedOrderModelMapper {

    public static PreCreatedOrderModel toModel(@NonNull CreateOrderInput preCreatedOrder) {
        return PreCreatedOrderModel.builder()
                .userId(preCreatedOrder.getUser().getId())
                .cargoLength(preCreatedOrder.getCargoLength())
                .cargoWidth(preCreatedOrder.getCargoWidth())
                .cargoHeight(preCreatedOrder.getCargoHeight())
                .cargoWeight(preCreatedOrder.getCargoWeight())
                .cargoType(preCreatedOrder.getCargoType())
                .departureLongitude(preCreatedOrder.getDepartureLongitude())
                .departureLatitude(preCreatedOrder.getDepartureLatitude())
                .departureTime(preCreatedOrder.getDepartureTime())
                .destinationLongitude(preCreatedOrder.getDestinationLongitude())
                .destinationLatitude(preCreatedOrder.getDestinationLatitude())
                .destinationTime(preCreatedOrder.getDestinationTime())
                .description(preCreatedOrder.getDescription())
                .needLoader(preCreatedOrder.getNeedLoader())
                .paymentMethod(preCreatedOrder.getPaymentMethod())
                .build();
    }
}
