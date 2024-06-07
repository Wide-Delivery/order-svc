package com.widedelivery.utils;

import com.google.maps.model.TravelMode;
import com.widedelivery.order.entity.DriverTripDto;
import com.widedelivery.order.entity.GeoLocationPoint;
import com.widedelivery.order.entity.OrderMatchingModel;
import com.widedelivery.order.service.RouteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GeoLocationUtilsTest {

    @Test
    public void testGenerateRandomGeoLocationPoint() {
        GeoLocationPoint point = GeoLocationUtils.generateRandomGeoLocationPoint();
        assertTrue(point.getLatitude() >= 46.3912047 && point.getLatitude() <= 51.9068063);
        assertTrue(point.getLongitude() >= 22.2593465 && point.getLongitude() <= 38.0494896);
    }

    @Test
    public void testCalculateTimeBetweenGeoLocationPoints() throws Exception {
        // mock
        RouteService routeService = Mockito.mock(RouteService.class);
        when(routeService.calculateRouteTime("46.3912047,22.2593465", "51.9068063,38.0494896", TravelMode.DRIVING)).thenReturn(1000L);
        GeoLocationUtils.setRouteService(routeService);

        GeoLocationPoint point1 = new GeoLocationPoint(46.3912047, 22.2593465);
        GeoLocationPoint point2 = new GeoLocationPoint(51.9068063, 38.0494896);

        // when
        long time = GeoLocationUtils.calculateTimeBetweenGeoLocationPoints(point1, point2);

        // then
        assertEquals(1000L, time);
    }

    @Test
    public void testCalculateOrderRelevanceForDriverTripReturnHighestCoefficientForTheSameRoutes() throws Exception {
        //mock
        RouteService routeService = Mockito.mock(RouteService.class);
        GeoLocationUtils.setRouteService(routeService);

        OrderMatchingModel order = new OrderMatchingModel();
        order.setDepartureLatitude("46.3912047");
        order.setDepartureLongitude("22.2593465");
        order.setDestinationLatitude("51.9068063");
        order.setDestinationLongitude("38.0494896");

        DriverTripDto driverTrip = new DriverTripDto();
        driverTrip.setDepartureLatitude("46.3912047");
        driverTrip.setDepartureLongitude("22.2593465");
        driverTrip.setDestinationLatitude("51.9068063");
        driverTrip.setDestinationLongitude("38.0494896");


        when(routeService.calculateRouteTime("46.3912047,22.2593465", "51.9068063,38.0494896", TravelMode.DRIVING)).thenReturn(1000L);

        // when
        double coeff = GeoLocationUtils.calculateOrderRelevanceForDriverTrip(order, driverTrip);

        // then
        assertEquals(1, coeff);
    }

    @Test
    public void testCalculateOrderRelevanceForDriverTripReturnZeroForVeryDifferentRoutes() throws Exception {
        // mock
        RouteService routeService = Mockito.mock(RouteService.class);
        GeoLocationUtils.setRouteService(routeService);

        OrderMatchingModel order = new OrderMatchingModel();
        order.setDepartureLatitude("21.3912047");
        order.setDepartureLongitude("10.2593465");
        order.setDestinationLatitude("23.1122334");
        order.setDestinationLongitude("12.0123456");

        DriverTripDto driverTrip = new DriverTripDto();
        driverTrip.setDepartureLatitude("46.3912047");
        driverTrip.setDepartureLongitude("22.2593465");
        driverTrip.setDestinationLatitude("51.9068063");
        driverTrip.setDestinationLongitude("38.0494896");

        when(routeService.calculateRouteTime("46.3912047,22.2593465", "51.9068063,38.0494896", TravelMode.DRIVING)).thenReturn(2000L);
        when(routeService.calculateRouteTime("21.3912047,10.2593465", "23.1122334,12.0123456", TravelMode.DRIVING)).thenReturn(5000L);

        when(routeService.calculateRouteTime("46.3912047,22.2593465", "21.3912047,10.2593465", TravelMode.DRIVING)).thenReturn(6500L);
        when(routeService.calculateRouteTime("23.1122334,12.0123456", "51.9068063,38.0494896", TravelMode.DRIVING)).thenReturn(90000L);

        // when
        double coeff = GeoLocationUtils.calculateOrderRelevanceForDriverTrip(order, driverTrip);

        // then
        assertEquals(0, coeff);
    }

    @Test
    public void testCalculateOrderRelevanceForDriverTripNeverMoreThanOneOrLessThanZero() throws Exception {
        // mock
        RouteService routeService = Mockito.mock(RouteService.class);
        GeoLocationUtils.setRouteService(routeService);
        GeoLocationUtils.setMIN_LATITUDE(-180);
        GeoLocationUtils.setMAX_LATITUDE(180);
        GeoLocationUtils.setMIN_LONGITUDE(-90);
        GeoLocationUtils.setMAX_LONGITUDE(90);

        when(routeService.calculateRouteTime(anyString(), anyString(), eq(TravelMode.DRIVING))).thenReturn(new Random().nextLong());

        for (int i = 0; i < 100_000; i++) {
            OrderMatchingModel order = new OrderMatchingModel();
            order.setDepartureLatitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()));
            order.setDepartureLongitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()));
            order.setDestinationLatitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()));
            order.setDestinationLongitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()));

            DriverTripDto driverTrip = new DriverTripDto();
            driverTrip.setDepartureLatitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()));
            driverTrip.setDepartureLongitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()));
            driverTrip.setDestinationLatitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()));
            driverTrip.setDestinationLongitude(String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()));

            // when
            double coeff = GeoLocationUtils.calculateOrderRelevanceForDriverTrip(order, driverTrip);

            // then
            assertTrue(coeff >= 0 && coeff <= 1);

            // log to check correctenss of input points
            if (i % 1000 == 0) {
                System.out.println("coeff = " + coeff + " order from: " + order.getDepartureLatitude() + "," +
                        order.getDepartureLongitude() + " to: " + order.getDestinationLatitude() + ","
                        + order.getDestinationLongitude());
            }
        }
    }

}
