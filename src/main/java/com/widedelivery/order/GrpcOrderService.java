package com.widedelivery.order;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.OrderStatus;
import com.widedelivery.order.entity.PreCreatedOrderModel;
import com.widedelivery.order.mapper.OrderMapper;
import com.widedelivery.order.mapper.PreCreatedOrderModelMapper;
import com.widedelivery.order.proto.CreateOrderInput;
import com.widedelivery.order.proto.CreateOrderResponse;
import com.widedelivery.order.proto.Order;
import com.widedelivery.order.proto.OrderResponse;
import com.widedelivery.order.service.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void getOrders(GetOrdersRequest request, StreamObserver<GetOrdersResponse> responseObserver) {
        int pageNumber = request.getPageNumber();
        int pageSize = request.getPageSize();

        Page<OrderModel> orders = orderService.getOrders(pageNumber, pageSize);
        List<Order> grpcOrders = orders
                .stream()
                .map(OrderMapper::toGrpcModel)
                .toList();

        GetOrdersResponse response = GetOrdersResponse.newBuilder()
                .addAllOrders(grpcOrders)
                .setTotalPages(orders.getTotalPages())
                .setCurrentPage(pageNumber)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void searchOrders(SearchOrdersRequest request, StreamObserver<SearchOrdersResponse> responseObserver) {
        int pageNumber = request.getPageNumber();
        int pageSize = request.getPageSize();
        Map<String, String> searchParams = request.getSearchParamsMap();
        Map<String, Object> convertedSearchParams = new HashMap<>();

        searchParams.forEach((key, value) -> {
            switch (key) {
                case "id":
                case "userId":
                case "driverId":
                    convertedSearchParams.put(key, new ObjectId(value));
                    break;
                case "status":
                    convertedSearchParams.put(key, OrderStatus.valueOf(value));
                    break;
                case "needLoader":
                    convertedSearchParams.put(key, Boolean.parseBoolean(value));
                    break;
                case "cargoLength":
                case "cargoWidth":
                case "cargoHeight":
                case "cargoWeight":
                    convertedSearchParams.put(key, Double.parseDouble(value));
                    break;
                case "createdAt":
                case "updatedAt":
                case "departureTime":
                case "destinationTime":
                    convertedSearchParams.put(key, Instant.parse(value));
                    break;
                default:
                    convertedSearchParams.put(key, value);
            }
        });

        Page<OrderModel> orders = orderService.searchOrders(
                convertedSearchParams,
                PageRequest.of(pageNumber - 1, pageSize)
        );

        List<Order> grpcOrders = orders
                .stream()
                .map(OrderMapper::toGrpcModel)
                .toList();

        SearchOrdersResponse response = SearchOrdersResponse.newBuilder()
                .addAllOrders(grpcOrders)
                .setTotalPages(orders.getTotalPages())
                .setCurrentPage(pageNumber)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
