package com.widedelivery.order.services;

import com.google.maps.GeoApiContext;
import com.google.maps.DirectionsApi;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private static String GOOGLE_API_KEY  = "AIzaSyASo8nJHb7xP42dUibFypzWZkeDuHxRn14";

    @Value("${google.maps.apiKey}")
    private void setApiKey(String apiKey) {
        GOOGLE_API_KEY = apiKey;
        if (apiKey == null) {
            GOOGLE_API_KEY = "AIzaSyASo8nJHb7xP42dUibFypzWZkeDuHxRn14";
        }
    }

    private String getApiKey() {
        return GOOGLE_API_KEY;
    }

    public static long calculateRouteTime(String origin, String destination, TravelMode mode) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(GOOGLE_API_KEY)
                .build();

        DirectionsResult result = DirectionsApi.newRequest(context)
                .mode(mode)
                .origin(origin)
                .destination(destination)
                .await();

        return result.routes[0].legs[0].duration.inSeconds;
    }
}
