package com.widedelivery.order.entity;

import com.widedelivery.driver.proto.DriverOuterClass;
import com.widedelivery.driver.proto.TruckOuterClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

    private String driverId;

    private boolean mayBeLoader;

    private int searchRadius;

    private TruckDto truck;

    private List<DriverTripDto> trips;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TruckDto {
        private double freeSpaceLength;

        private double freeSpaceWidth;

        private double freeSpaceHeight;

        private boolean isAvailableNow;

        public TruckOuterClass.Truck getGrpcMessage() {
            return TruckOuterClass.Truck
                    .newBuilder()
                    .setFreeSpaceLength(this.freeSpaceLength)
                    .setFreeSpaceWidth(this.freeSpaceWidth)
                    .setFreeSpaceHeight(this.freeSpaceHeight)
                    .setIsAvailableNow(this.isAvailableNow)
                    .build();
        }

        public static TruckDto parseFromGrpcMessage(TruckOuterClass.Truck truck) {
            TruckDto truckDto = new TruckDto();
            truckDto.setFreeSpaceLength(truck.getFreeSpaceLength());
            truckDto.setFreeSpaceWidth(truck.getFreeSpaceWidth());
            truckDto.setFreeSpaceHeight(truck.getFreeSpaceHeight());
            truckDto.setAvailableNow(truck.getIsAvailableNow());
            return truckDto;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    ", freeSpaceLength=" + freeSpaceLength +
                    ", freeSpaceWidth=" + freeSpaceWidth +
                    ", freeSpaceHeight=" + freeSpaceHeight +
                    ", isAvailableNow=" + isAvailableNow +
                    '}';
        }
    }

    public DriverOuterClass.Driver getGrpcMessage() {
        return DriverOuterClass.Driver
                .newBuilder()
                .setDriverId(this.driverId)
                .setMayBeLoader(this.mayBeLoader)
                .setSearchRadius(this.searchRadius)
                .setTruck(this.truck.getGrpcMessage())
                .build();
    }

    public static DriverDto parseFromGrpcMessage(DriverOuterClass.DriverWithTrips driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setDriverId(driver.getDriver().getDriverId());
        driverDto.setMayBeLoader(driver.getDriver().getMayBeLoader());
        driverDto.setSearchRadius(driver.getDriver().getSearchRadius());
        driverDto.setTruck(TruckDto.parseFromGrpcMessage(driver.getDriver().getTruck()));
        driverDto.setTruck(TruckDto.parseFromGrpcMessage(driver.getDriver().getTruck()));
        driverDto.setTrips(driver
                .getTripsList()
                .stream()
                .map(DriverTripDto::parseFromGrpcMessage)
                .collect(Collectors.toList())
        );
        return driverDto;
    }

    @Override
    public String toString() {
        return "DriverModel{" +
                "driverId='" + driverId + '\'' +
                ", mayBeLoader=" + mayBeLoader +
                ", searchRadius=" + searchRadius +
                ", truck=" + truck +
                '}';
    }
}
