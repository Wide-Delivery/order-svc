package com.widedelivery.order.services;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.models.OrderModel;
import com.widedelivery.order.models.PreCreatedOrderModel;
import com.widedelivery.order.repos.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
//    private static final Logger logger = new Logger(OrderServiceImpl.class.getName())
    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderModel createOrder(PreCreatedOrderModel preCreatedOrderModel) {
        OrderModel newOrder = orderRepository.save(OrderModel.getFromPreCreateModel(preCreatedOrderModel));

        System.out.println(newOrder);
        return newOrder;
//        return new OrderModel(
//                "123_order",
//                preCreatedOrderModel.getUserId(),
//                preCreatedOrderModel.getCargoLength(),
//                preCreatedOrderModel.getCargoWidth(),
//                preCreatedOrderModel.getCargoHeight(),
//                preCreatedOrderModel.getCargoWeight(),
//                preCreatedOrderModel.getDepartureLongitude(),
//                preCreatedOrderModel.getDepartureLatitude(),
//                preCreatedOrderModel.getDepartureTime(),
//                preCreatedOrderModel.getDestinationLongitude(),
//                preCreatedOrderModel.getDestinationLatitude(),
//                preCreatedOrderModel.getDestinationTime(),
//                preCreatedOrderModel.getDescription(),
//                preCreatedOrderModel.isNeedLoader(),
//                preCreatedOrderModel.getPaymentMethod(),
//                Timestamp.newBuilder().setSeconds(1715040900).build(),
//                Timestamp.newBuilder().setSeconds(1715040900).build()
//        );
    }

    @Override
    public OrderModel getOrder(String orderId) {
        return orderRepository.findById(new ObjectId(orderId)).orElse(null);
    }
}
