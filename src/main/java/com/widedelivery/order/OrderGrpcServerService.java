package com.widedelivery.order;

import com.widedelivery.order.models.OrderModel;
import com.widedelivery.order.models.PreCreatedOrderModel;
import com.widedelivery.order.proto.CreateOrderInput;
import com.widedelivery.order.proto.CreateOrderResponse;
import com.widedelivery.order.proto.GetOrderInput;
import com.widedelivery.order.proto.OrderResponse;
import com.widedelivery.order.proto.OrderServiceGrpc.OrderServiceImplBase;
import com.widedelivery.order.services.OrderService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@GrpcService
public class OrderGrpcServerService extends OrderServiceImplBase {
    private static final Logger logger = Logger.getLogger(OrderGrpcServerService.class.getName());

    @Autowired
    OrderService orderService;

    @Override
    public void createOrder(CreateOrderInput request, StreamObserver<CreateOrderResponse> responseObserver) {
        PreCreatedOrderModel preCreatedOrderModel = PreCreatedOrderModel.getFromGrpcRequest(request);

        OrderModel newOrderModel = orderService.createOrder(preCreatedOrderModel);
        logger.info("Creating order" + newOrderModel);
        responseObserver.onNext(
                CreateOrderResponse
                        .newBuilder()
                        .setOrder(newOrderModel.getGrpcMessage())
                        .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getOrder(GetOrderInput request, StreamObserver<OrderResponse> responseObserver) {
        OrderModel order = orderService.getOrder(request.getOrderId());
        responseObserver.onNext(OrderResponse
                .newBuilder()
                .setOrder(
                        order.getGrpcMessage())
                .build());
        responseObserver.onCompleted();
    }

    private CreateOrderResponse createOrderService(CreateOrderInput request) {
        return CreateOrderResponse.newBuilder().setOrder(com.widedelivery.order.proto.Order.newBuilder()).build();
    }

    private OrderResponse getOrderService(GetOrderInput request) {
        return OrderResponse.newBuilder().setOrder(com.widedelivery.order.proto.Order.newBuilder()).build();
    }
}
