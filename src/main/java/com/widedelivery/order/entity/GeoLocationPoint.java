package com.widedelivery.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeoLocationPoint {
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return "GeoLocationPoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
