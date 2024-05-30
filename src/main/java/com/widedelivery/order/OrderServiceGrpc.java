package com.widedelivery.order;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: services.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "order.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.widedelivery.order.proto.CreateOrderInput,
      com.widedelivery.order.proto.CreateOrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = com.widedelivery.order.proto.CreateOrderInput.class,
      responseType = com.widedelivery.order.proto.CreateOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.widedelivery.order.proto.CreateOrderInput,
      com.widedelivery.order.proto.CreateOrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<com.widedelivery.order.proto.CreateOrderInput, com.widedelivery.order.proto.CreateOrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
          OrderServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<com.widedelivery.order.proto.CreateOrderInput, com.widedelivery.order.proto.CreateOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.CreateOrderInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.CreateOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CreateOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetOrderInput,
      com.widedelivery.order.proto.OrderResponse> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.widedelivery.order.proto.GetOrderInput.class,
      responseType = com.widedelivery.order.proto.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetOrderInput,
      com.widedelivery.order.proto.OrderResponse> getGetOrderMethod() {
    io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetOrderInput, com.widedelivery.order.proto.OrderResponse> getGetOrderMethod;
    if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
          OrderServiceGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<com.widedelivery.order.proto.GetOrderInput, com.widedelivery.order.proto.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.GetOrderInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.widedelivery.order.proto.AddDriverToMatchingInput,
      com.widedelivery.order.proto.GenericResponse> getAddDriverForMatchingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDriverForMatching",
      requestType = com.widedelivery.order.proto.AddDriverToMatchingInput.class,
      responseType = com.widedelivery.order.proto.GenericResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.widedelivery.order.proto.AddDriverToMatchingInput,
      com.widedelivery.order.proto.GenericResponse> getAddDriverForMatchingMethod() {
    io.grpc.MethodDescriptor<com.widedelivery.order.proto.AddDriverToMatchingInput, com.widedelivery.order.proto.GenericResponse> getAddDriverForMatchingMethod;
    if ((getAddDriverForMatchingMethod = OrderServiceGrpc.getAddDriverForMatchingMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getAddDriverForMatchingMethod = OrderServiceGrpc.getAddDriverForMatchingMethod) == null) {
          OrderServiceGrpc.getAddDriverForMatchingMethod = getAddDriverForMatchingMethod =
              io.grpc.MethodDescriptor.<com.widedelivery.order.proto.AddDriverToMatchingInput, com.widedelivery.order.proto.GenericResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDriverForMatching"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.AddDriverToMatchingInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.GenericResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("AddDriverForMatching"))
              .build();
        }
      }
    }
    return getAddDriverForMatchingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.widedelivery.order.proto.RemoveDriverFromMatchingInput,
      com.widedelivery.order.proto.GenericResponse> getRemoveDriverFromMatchingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveDriverFromMatching",
      requestType = com.widedelivery.order.proto.RemoveDriverFromMatchingInput.class,
      responseType = com.widedelivery.order.proto.GenericResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.widedelivery.order.proto.RemoveDriverFromMatchingInput,
      com.widedelivery.order.proto.GenericResponse> getRemoveDriverFromMatchingMethod() {
    io.grpc.MethodDescriptor<com.widedelivery.order.proto.RemoveDriverFromMatchingInput, com.widedelivery.order.proto.GenericResponse> getRemoveDriverFromMatchingMethod;
    if ((getRemoveDriverFromMatchingMethod = OrderServiceGrpc.getRemoveDriverFromMatchingMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getRemoveDriverFromMatchingMethod = OrderServiceGrpc.getRemoveDriverFromMatchingMethod) == null) {
          OrderServiceGrpc.getRemoveDriverFromMatchingMethod = getRemoveDriverFromMatchingMethod =
              io.grpc.MethodDescriptor.<com.widedelivery.order.proto.RemoveDriverFromMatchingInput, com.widedelivery.order.proto.GenericResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveDriverFromMatching"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.RemoveDriverFromMatchingInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.GenericResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("RemoveDriverFromMatching"))
              .build();
        }
      }
    }
    return getRemoveDriverFromMatchingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetMatchedOrdersInput,
      com.widedelivery.order.proto.GetMatchedOrdersOutput> getGetMatchedOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMatchedOrders",
      requestType = com.widedelivery.order.proto.GetMatchedOrdersInput.class,
      responseType = com.widedelivery.order.proto.GetMatchedOrdersOutput.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetMatchedOrdersInput,
      com.widedelivery.order.proto.GetMatchedOrdersOutput> getGetMatchedOrdersMethod() {
    io.grpc.MethodDescriptor<com.widedelivery.order.proto.GetMatchedOrdersInput, com.widedelivery.order.proto.GetMatchedOrdersOutput> getGetMatchedOrdersMethod;
    if ((getGetMatchedOrdersMethod = OrderServiceGrpc.getGetMatchedOrdersMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetMatchedOrdersMethod = OrderServiceGrpc.getGetMatchedOrdersMethod) == null) {
          OrderServiceGrpc.getGetMatchedOrdersMethod = getGetMatchedOrdersMethod =
              io.grpc.MethodDescriptor.<com.widedelivery.order.proto.GetMatchedOrdersInput, com.widedelivery.order.proto.GetMatchedOrdersOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMatchedOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.GetMatchedOrdersInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.widedelivery.order.proto.GetMatchedOrdersOutput.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetMatchedOrders"))
              .build();
        }
      }
    }
    return getGetMatchedOrdersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
        @Override
        public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceStub(channel, callOptions);
        }
      };
    return OrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
        @Override
        public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
        @Override
        public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceFutureStub(channel, callOptions);
        }
      };
    return OrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createOrder(com.widedelivery.order.proto.CreateOrderInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    /**
     */
    default void getOrder(com.widedelivery.order.proto.GetOrderInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     */
    default void addDriverForMatching(com.widedelivery.order.proto.AddDriverToMatchingInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDriverForMatchingMethod(), responseObserver);
    }

    /**
     */
    default void removeDriverFromMatching(com.widedelivery.order.proto.RemoveDriverFromMatchingInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveDriverFromMatchingMethod(), responseObserver);
    }

    /**
     */
    default void getMatchedOrders(com.widedelivery.order.proto.GetMatchedOrdersInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GetMatchedOrdersOutput> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMatchedOrdersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderService.
   */
  public static abstract class OrderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
    private OrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected OrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void createOrder(com.widedelivery.order.proto.CreateOrderInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrder(com.widedelivery.order.proto.GetOrderInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDriverForMatching(com.widedelivery.order.proto.AddDriverToMatchingInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDriverForMatchingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeDriverFromMatching(com.widedelivery.order.proto.RemoveDriverFromMatchingInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveDriverFromMatchingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMatchedOrders(com.widedelivery.order.proto.GetMatchedOrdersInput request,
        io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GetMatchedOrdersOutput> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMatchedOrdersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected OrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.widedelivery.order.proto.CreateOrderResponse createOrder(com.widedelivery.order.proto.CreateOrderInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.widedelivery.order.proto.OrderResponse getOrder(com.widedelivery.order.proto.GetOrderInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.widedelivery.order.proto.GenericResponse addDriverForMatching(com.widedelivery.order.proto.AddDriverToMatchingInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDriverForMatchingMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.widedelivery.order.proto.GenericResponse removeDriverFromMatching(com.widedelivery.order.proto.RemoveDriverFromMatchingInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveDriverFromMatchingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.widedelivery.order.proto.GetMatchedOrdersOutput> getMatchedOrders(
        com.widedelivery.order.proto.GetMatchedOrdersInput request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMatchedOrdersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrderService.
   */
  public static final class OrderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected OrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.widedelivery.order.proto.CreateOrderResponse> createOrder(
        com.widedelivery.order.proto.CreateOrderInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.widedelivery.order.proto.OrderResponse> getOrder(
        com.widedelivery.order.proto.GetOrderInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.widedelivery.order.proto.GenericResponse> addDriverForMatching(
        com.widedelivery.order.proto.AddDriverToMatchingInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDriverForMatchingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.widedelivery.order.proto.GenericResponse> removeDriverFromMatching(
        com.widedelivery.order.proto.RemoveDriverFromMatchingInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveDriverFromMatchingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER = 0;
  private static final int METHODID_GET_ORDER = 1;
  private static final int METHODID_ADD_DRIVER_FOR_MATCHING = 2;
  private static final int METHODID_REMOVE_DRIVER_FROM_MATCHING = 3;
  private static final int METHODID_GET_MATCHED_ORDERS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((com.widedelivery.order.proto.CreateOrderInput) request,
              (io.grpc.stub.StreamObserver<com.widedelivery.order.proto.CreateOrderResponse>) responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((com.widedelivery.order.proto.GetOrderInput) request,
              (io.grpc.stub.StreamObserver<com.widedelivery.order.proto.OrderResponse>) responseObserver);
          break;
        case METHODID_ADD_DRIVER_FOR_MATCHING:
          serviceImpl.addDriverForMatching((com.widedelivery.order.proto.AddDriverToMatchingInput) request,
              (io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse>) responseObserver);
          break;
        case METHODID_REMOVE_DRIVER_FROM_MATCHING:
          serviceImpl.removeDriverFromMatching((com.widedelivery.order.proto.RemoveDriverFromMatchingInput) request,
              (io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GenericResponse>) responseObserver);
          break;
        case METHODID_GET_MATCHED_ORDERS:
          serviceImpl.getMatchedOrders((com.widedelivery.order.proto.GetMatchedOrdersInput) request,
              (io.grpc.stub.StreamObserver<com.widedelivery.order.proto.GetMatchedOrdersOutput>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.widedelivery.order.proto.CreateOrderInput,
              com.widedelivery.order.proto.CreateOrderResponse>(
                service, METHODID_CREATE_ORDER)))
        .addMethod(
          getGetOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.widedelivery.order.proto.GetOrderInput,
              com.widedelivery.order.proto.OrderResponse>(
                service, METHODID_GET_ORDER)))
        .addMethod(
          getAddDriverForMatchingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.widedelivery.order.proto.AddDriverToMatchingInput,
              com.widedelivery.order.proto.GenericResponse>(
                service, METHODID_ADD_DRIVER_FOR_MATCHING)))
        .addMethod(
          getRemoveDriverFromMatchingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.widedelivery.order.proto.RemoveDriverFromMatchingInput,
              com.widedelivery.order.proto.GenericResponse>(
                service, METHODID_REMOVE_DRIVER_FROM_MATCHING)))
        .addMethod(
          getGetMatchedOrdersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.widedelivery.order.proto.GetMatchedOrdersInput,
              com.widedelivery.order.proto.GetMatchedOrdersOutput>(
                service, METHODID_GET_MATCHED_ORDERS)))
        .build();
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.widedelivery.order.proto.OrderProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getCreateOrderMethod())
              .addMethod(getGetOrderMethod())
              .addMethod(getAddDriverForMatchingMethod())
              .addMethod(getRemoveDriverFromMatchingMethod())
              .addMethod(getGetMatchedOrdersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
