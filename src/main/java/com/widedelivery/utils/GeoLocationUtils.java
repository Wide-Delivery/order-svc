package com.widedelivery.utils;

import com.google.maps.model.DirectionsResult;
import com.widedelivery.order.entity.DriverTripDto;
import com.widedelivery.order.entity.GeoLocationPoint;
import com.google.maps.model.TravelMode;
import com.widedelivery.order.entity.OrderMatchingModel;
import com.widedelivery.order.service.RouteService;
import lombok.Setter;
import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class GeoLocationUtils {
    @Setter
    private double MIN_LATITUDE = 46.3912047;
    @Setter
    private double MAX_LATITUDE = 51.9068063;
    @Setter
    private double MIN_LONGITUDE = 22.2593465;
    @Setter
    private double MAX_LONGITUDE = 38.0494896;

    private static final Random random = new Random();

    @Setter
    private RouteService routeService = new RouteService();

    public static GeoLocationPoint generateRandomGeoLocationPoint() {
        double latitude = MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * random.nextDouble();
        double longitude = MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * random.nextDouble();
        return new GeoLocationPoint(latitude, longitude);
    }

    public static long calculateTimeBetweenGeoLocationPoints(GeoLocationPoint point1, GeoLocationPoint point2) {
        String origin = point1.getLatitude() + "," + point1.getLongitude();
        String destination = point2.getLatitude() + "," + point2.getLongitude();

        try {
            return routeService.calculateRouteTime(origin, destination, TravelMode.DRIVING);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double calculateOrderRelevanceForDriverTrip(OrderMatchingModel order, DriverTripDto driverTrip) {
        String orderOrigin = order.getDepartureLatitude() + "," + order.getDepartureLongitude();
        String orderDestination = order.getDestinationLatitude() + "," + order.getDestinationLongitude();

        String driverTripOrigin = driverTrip.getDepartureLatitude() + "," + driverTrip.getDepartureLongitude();
        String driverTripDestination = driverTrip.getDestinationLatitude() + "," + driverTrip.getDestinationLongitude();

        try {
            long driverTripTime = routeService.calculateRouteTime(driverTripOrigin, driverTripDestination, TravelMode.DRIVING);
            long orderNeededTime = routeService.calculateRouteTime(orderOrigin, orderDestination, TravelMode.DRIVING);
            long extraTimeToCompleteOrder = routeService.calculateRouteTime(driverTripOrigin, orderOrigin, TravelMode.DRIVING) +
                    routeService.calculateRouteTime(orderDestination, driverTripDestination, TravelMode.DRIVING);

            double deltaMax = 0.05 * driverTripTime + 0.1 * orderNeededTime;
            return Math.max(0, Math.min(1, 1 - extraTimeToCompleteOrder / (driverTripTime + deltaMax)));
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Cannot calculate time between points");
        }
    }

    public static DirectionsResult getGoogleDirectionBetweenPoints(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        String origin = fromLatitude + "," + fromLongitude;
        String destination = toLatitude + "," + toLongitude;

        try {
            return routeService.getAllInfoAboutRoute(origin, destination, TravelMode.DRIVING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Cannot get route between %s and %s", origin, destination));
        }
    }
}
