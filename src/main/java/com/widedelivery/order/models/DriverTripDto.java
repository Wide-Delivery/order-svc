package com.widedelivery.order.models;

import com.google.protobuf.Timestamp;
import com.widedelivery.driver.proto.DriverTrip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverTripDto {

    private String id;

    private String driverId;

    private String departureLongitude;

    private String departureLatitude;

    private Timestamp departureTime;

    private String destinationLongitude;

    private String destinationLatitude;

    private Timestamp destinationTime;

    private double freeSpaceLength;

    private double freeSpaceWidth;

    private double freeSpaceHeight;

    private DriverTripStatus status;

    private List<OrderMatchingModel> acceptedOrders;

    public static DriverTripDto parseFromGrpcMessage(DriverTrip trip) {
        DriverTripDto driverTripDto = new DriverTripDto();
        driverTripDto.setId(trip.getTripId());
        driverTripDto.setDriverId(trip.getDriverId());
        driverTripDto.setDepartureLatitude(trip.getDepartureLatitude());
        driverTripDto.setDepartureLongitude(trip.getDepartureLongitude());
        driverTripDto.setDestinationLatitude(trip.getDestinationLatitude());
        driverTripDto.setDepartureLongitude(trip.getDestinationLongitude());
        driverTripDto.setDepartureTime(trip.getDepartureTime());
        driverTripDto.setDestinationTime(trip.getDestinationTime());

        driverTripDto.setFreeSpaceLength(trip.getFreeSpaceLength());
        driverTripDto.setFreeSpaceHeight(trip.getFreeSpaceHeight());
        driverTripDto.setFreeSpaceWidth(trip.getFreeSpaceWidth());

        driverTripDto.setStatus(DriverTripStatus.valueOf(trip.getStatus().name()));
        driverTripDto.setAcceptedOrders(trip
                .getAcceptedOrdersList()
                .stream()
                .map(OrderMatchingModel::parseFromGrpcMessage)
                .toList());
        return driverTripDto;
    }

}
