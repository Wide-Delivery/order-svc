//package com.widedelivery.order;
//
//import com.widedelivery.order.proto.*;
//import com.widedelivery.order.service.DriverService;
//import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.logging.Logger;
//
//@GrpcService
//public class DriverGrpcServerService extends DriverServiceIm {
//    private static final Logger logger = Logger.getLogger(DriverGrpcServerService.class.getName());
//
//    @Autowired
//    private DriverService driverService;
//
//    @Override
//    public void createOrder(CreateOrderInput request,
//                            StreamObserver<CreateOrderResponse> responseObserver) {
//        PreCreatedOrderModel preCreatedOrderModel = PreCreatedOrderModel.getFromGrpcRequest(request);
//
//        OrderModel newOrderModel = orderService.createOrder(preCreatedOrderModel);
//        logger.info("Creating order" + newOrderModel);
//        responseObserver.onNext(
//                CreateOrderResponse
//                        .newBuilder()
//                        .setOrder(newOrderModel.getGrpcMessage())
//                        .build());
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void getMatchedOrders(GetMatchedOrdersInput request, StreamObserver<GetMatchedOrdersOutput> responseObserver) {
//        logger.info("Receive order" + request);
//        responseObserver.onNext(getOrderService(request));
//        responseObserver.onCompleted();
////    }
//
//    @Override
//    public void addDriverForMatching(AddDriverToMatchingInput request, StreamObserver<GenericResponse> responseObserver) {
//        String driverId = request.getDriverId();
//         Implement logic to add driver to matching
//        String success = addDriverToMatching(driverId);
//
//        GenericResponse response = GenericResponse.newBuilder()
//                .setStatus(success)
//                .setMessage(success.isEmpty() ? "Driver added to matching" : "Failed to add driver to matching")
//                .build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void removeDriverFromMatching(RemoveDriverFromMatchingInput request, StreamObserver<GenericResponse> responseObserver) {
//        String driverId = request.getDriverId();
//         Implement logic to remove driver from matching
//        boolean success = removeDriverFromMatching(driverId);
//
//        GenericResponse response = GenericResponse.newBuilder()
//                .setSuccess(success)
//                .setMessage(success ? "Driver removed from matching" : "Failed to remove driver from matching")
//                .build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void getMatchedOrders(GetMatchedOrdersInput request, StreamObserver<GetMatchedOrdersOutput> responseObserver) {
//        String driverId = request.getDriverId();
//         Fetch matched orders for the driver
//        List<Order> matchedOrders = getMatchedOrdersForDriver(driverId);
//
//        for (Order order : matchedOrders) {
//            GetMatchedOrdersOutput output = GetMatchedOrdersOutput.newBuilder()
//                    .setOrder(order)
//                    .build();
//            responseObserver.onNext(output);
//        }
//        responseObserver.onCompleted();
//    }
//}
