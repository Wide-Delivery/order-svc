//import com.google.maps.*;
//import com.google.maps.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class OrderPickingService {
//
//    private final OrderRepository orderRepository;
//    private final GeoApiContext geoApiContext;
//
//    @Autowired
//    public OrderService(OrderRepository orderRepository, GeoApiContext geoApiContext) {
//        this.orderRepository = orderRepository;
//        this.geoApiContext = geoApiContext;
//    }
//
//    public List<OrderModel> findOrdersAlongRoute(DriverTripModel driverTrip) throws Exception {
//        List<OrderModel> allOrders = orderRepository.findAll();
//
//        DirectionsResult directionsResult = getDirections(driverTrip);
//        List<LatLng> routePoints = extractRoutePoints(directionsResult);
//
//        return allOrders.stream()
//                .filter(order -> isOrderAlongRoute(order, routePoints, driverTrip))
//                .collect(Collectors.toList());
//    }
//
//    private DirectionsResult getDirections(DriverTripModel driverTrip) throws Exception {
//        return DirectionsApi.newRequest(geoApiContext)
//                .origin(new LatLng(Double.parseDouble(driverTrip.getDepartureLatitude()), Double.parseDouble(driverTrip.getDepartureLongitude())))
//                .destination(new LatLng(Double.parseDouble(driverTrip.getDestinationLatitude()), Double.parseDouble(driverTrip.getDestinationLongitude())))
//                .await();
//    }
//
//    private List<LatLng> extractRoutePoints(DirectionsResult directionsResult) {
//        return directionsResult.routes[0].overviewPolyline.decodePath();
//    }
//
//    private boolean isOrderAlongRoute(OrderModel order, List<LatLng> routePoints, DriverTripModel driverTrip) {
//        LatLng orderLocation = new LatLng(Double.parseDouble(order.getDepartureLatitude()), Double.parseDouble(order.getDepartureLongitude()));
//
//        // Check if order is near the route (within a certain distance)
//        boolean nearRoute = routePoints.stream()
//                .anyMatch(point -> getDistance(point, orderLocation) < 5000); // Example: within 5km of the route
//
//        // Check time constraints
//        boolean timeConstraintsMet = true;
//        if (order.getDepartureTime() != null) {
//            timeConstraintsMet &= !driverTrip.getDepartureTime().after(order.getDepartureTime());
//        }
//        if (order.getDestinationTime() != null) {
//            timeConstraintsMet &= !driverTrip.getDestinationTime().before(order.getDestinationTime());
//        }
//
//        // Check if driver can handle orders that need a loader
//        boolean canHandleLoader = !order.isNeedLoader() || driverTrip.isMayBeLoader();
//
//        return nearRoute && timeConstraintsMet && canHandleLoader;
//    }
//
//    private double getDistance(LatLng point1, LatLng point2) {
//        // Implement distance calculation (e.g., Haversine formula)
//        double R = 6371e3; // Earth radius in meters
//        double lat1 = Math.toRadians(point1.lat);
//        double lat2 = Math.toRadians(point2.lat);
//        double deltaLat = Math.toRadians(point2.lat - point1.lat);
//        double deltaLon = Math.toRadians(point2.lng - point1.lng);
//
//        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
//                Math.cos(lat1) * Math.cos(lat2) *
//                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//
//        return R * c;
//    }
//}
