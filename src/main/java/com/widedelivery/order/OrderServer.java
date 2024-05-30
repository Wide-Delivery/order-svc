package com.widedelivery.order;

import com.widedelivery.order.proto.CreateOrderInput;
import com.widedelivery.order.proto.CreateOrderResponse;
import com.widedelivery.order.proto.GetOrderInput;
import com.widedelivery.order.proto.OrderResponse;
import com.widedelivery.order.proto.OrderServiceGrpc;

//@Component
//public class OrderServer {
//    private static final Logger logger = Logger.getLogger(OrderServer.class.getName());
//
//    @Autowired
//    com.widedelivery.order.services.OrderService orderService;
//
//    private final int port;
//    private final Server server;
//
//    public OrderServer() throws IOException {
//        this(3006);
//    }
//
//    public OrderServer(int port) throws IOException {
//        this.port = port;
//        this.server = Grpc
//                .newServerBuilderForPort(port, InsecureServerCredentials.create())
//                .addService(new OrderService()).build();
//    }
//
//    public void start() throws IOException {
//        server.start();
//        logger.info("Server started, listening on " + port);
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
//                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//                try {
//                    OrderServer.this.stop();
//                } catch (InterruptedException e) {
//                    e.printStackTrace(System.err);
//                }
//                System.err.println("*** server shut down");
//            }
//        });
//    }
//
//    public void stop() throws InterruptedException {
//        if (server != null) {
//            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
//        }
//    }
//
//    public void blockUntilShutdown() throws InterruptedException { //TODO changes
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//
////    public static void main(String[] args) throws Exception {
////        SpringApplication.run(OrderSvcApplication.class, args);
////    }
//
//    private class OrderService extends OrderServiceGrpc.OrderServiceImplBase {
//
//        OrderService() {
//
//        }
//
//        @Override
//        public void createOrder(CreateOrderInput request,
//                                StreamObserver<CreateOrderResponse> responseObserver) {
//            PreCreatedOrderModel preCreatedOrderModel = PreCreatedOrderModel.getFromGrpcRequest(request);
//
//            OrderModel newOrderModel = orderService.createOrder(preCreatedOrderModel);
//            logger.info("Creating order" + newOrderModel);
//            responseObserver.onNext(
//                    CreateOrderResponse
//                            .newBuilder()
//                            .setOrder(newOrderModel.getGrpcMessage())
//                            .build());
//            responseObserver.onCompleted();
//        }
//
//        @Override
//        public void getOrder(GetOrderInput request, StreamObserver<OrderResponse> responseObserver) {
//            logger.info("Receive order" + request);
//            responseObserver.onNext(getOrderService(request));
//            responseObserver.onCompleted();
//        }
//
//        private CreateOrderResponse createOrderService(CreateOrderInput request) {
//            return CreateOrderResponse.newBuilder().setOrder(com.widedelivery.order.proto.Order.newBuilder()).build();
//        }
//
//        private OrderResponse getOrderService(GetOrderInput request) {
//            return OrderResponse.newBuilder().setOrder(com.widedelivery.order.proto.Order.newBuilder()).build();
//        }
//    }
//
//}
