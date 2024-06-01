package com.widedelivery.order;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.mapper.OrderMapper;
import com.widedelivery.order.mapper.PreCreatedOrderModelMapper;
import com.widedelivery.order.proto.CreateOrderInput;
import com.widedelivery.order.proto.CreateOrderResponse;
import com.widedelivery.order.proto.OrderResponse;
import com.widedelivery.order.service.GetOrderInput;
import com.widedelivery.order.service.OrderService;
import com.widedelivery.order.service.OrderServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@GrpcService
public class GrpcOrderService extends OrderServiceGrpc.OrderServiceImplBase {

    private static final Logger logger = LogManager.getLogger(GrpcOrderService.class);

    private final OrderService orderService;

    public GrpcOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void createOrder(CreateOrderInput request, StreamObserver<CreateOrderResponse> responseObserver) {
        try {
            PreCreatedOrderModel preCreatedOrderModel = PreCreatedOrderModelMapper.toModel(request);

            OrderModel newOrderModel = orderService.createOrder(preCreatedOrderModel);

            logger.info("Order created successfully: {}", newOrderModel);

            CreateOrderResponse response = CreateOrderResponse.newBuilder()
                    .setOrder(OrderMapper.toGrpcModel(newOrderModel))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            logger.error("Failed to create order: {}", e.getMessage(), e);
            responseObserver.onError(Status.INTERNAL.withDescription("Order creation failed").asRuntimeException());
        }
    }

    @Override
    public void getOrder(GetOrderInput request, StreamObserver<OrderResponse> responseObserver) {
        String id = request.getOrderId();

        OrderModel order = orderService.getOrder(id);

        responseObserver.onNext(OrderResponse
                .newBuilder()
                .setOrder(OrderMapper.toGrpcModel(order))
                .build());

        responseObserver.onCompleted();
    }
}
