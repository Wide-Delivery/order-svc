package com.widedelivery.utils;

import com.widedelivery.order.entity.DriverTripDto;
import com.widedelivery.order.entity.GeoLocationPoint;
import com.google.maps.model.TravelMode;
import com.widedelivery.order.entity.OrderMatchingModel;
import com.widedelivery.order.service.RouteService;

import java.util.Random;

public class GeoLocationUtils {
    private static final double MIN_LATITUDE = 46.3912047;
    private static final double MAX_LATITUDE = 51.9068063;
    private static final double MIN_LONGITUDE = 22.2593465;
    private static final double MAX_LONGITUDE = 38.0494896;

    private static final Random random = new Random();

    public static GeoLocationPoint generateRandomGeoLocationPoint() {
        double latitude = MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * random.nextDouble();
        double longitude = MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * random.nextDouble();
        return new GeoLocationPoint(latitude, longitude);
    }

    public static long calculateTimeBetweenGeoLocationPoints(GeoLocationPoint point1, GeoLocationPoint point2) {
        String origin = point1.getLatitude() + "," + point1.getLongitude();
        String destination = point2.getLatitude() + "," + point2.getLongitude();

        try {
            return RouteService.calculateRouteTime(origin, destination, TravelMode.DRIVING);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double calculateCoeff(OrderMatchingModel order, DriverTripDto driverTrip) {
        String orderOrigin = order.getDepartureLongitude() + "," + order.getDepartureLatitude();
        String orderDestination = order.getDestinationLongitude() + "," + order.getDestinationLatitude();

        String driverTripOrigin = driverTrip.getDepartureLongitude() + "," + driverTrip.getDepartureLatitude();
        String driverTripDestination = driverTrip.getDestinationLongitude() + "," + driverTrip.getDestinationLatitude();

        try {
            long timeDriver = RouteService.calculateRouteTime(driverTripOrigin, driverTripDestination, TravelMode.DRIVING);
            long timeOrder = RouteService.calculateRouteTime(orderOrigin, orderDestination, TravelMode.DRIVING);
            long extraTime = RouteService.calculateRouteTime(driverTripOrigin, orderOrigin, TravelMode.DRIVING) +
                    RouteService.calculateRouteTime(orderDestination, driverTripDestination, TravelMode.DRIVING);

            double deltaMax = 0.05 * timeDriver + 0.1 * timeOrder;
            double k = Math.max(0, Math.min(1, 1 - extraTime / (timeDriver + deltaMax)));
            return k;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }
}
