package com.widedelivery.order.mapper;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.proto.Order;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.PropertySource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@PropertySource("classpath:application.properties")
public class OrderMapperTest {

    @Test
    public void testToGrpcModel() {
//        OrderModel orderModel = new OrderModel();
//        orderModel.setId(new ObjectId("60d5ec9af682fbd39a1a36a9"));
//        orderModel.setUserId(new ObjectId("60d5ec9af682fbd39a1a36a9"));
//        orderModel.setCargoLength(10);
//        orderModel.setCargoWidth(10);
//        orderModel.setCargoHeight(10);
//        orderModel.setDepartureLatitude("48.3241422");
//        orderModel.setDepartureLongitude("35.5567891");
//        orderModel.setDestinationLatitude("48.3241422");
//        orderModel.setDestinationLongitude("48.3241422");
//        orderModel.setDescription("description");
//        orderModel.setNeedLoader(true);
//        orderModel.setPaymentMethod("VISA-07821");
//        orderModel.setCreatedAt(Instant.now());
//        orderModel.setUpdatedAt(Instant.now());
//
//        Order order = OrderMapper.toGrpcModel(orderModel);
//
//        assertEquals(orderModel.getId().toString(), order.getId());
//        assertEquals(orderModel.getUserId().toString(), order.getUserId());
//        assertEquals(orderModel.getCargoLength(), order.getCargoLength());
//        assertEquals(orderModel.getCargoWidth(), order.getCargoWidth());
//        assertEquals(orderModel.getCargoHeight(), order.getCargoHeight());
//        assertEquals(orderModel.getDepartureLongitude(), order.getDepartureLongitude());
//        assertEquals(orderModel.getDepartureLatitude(), order.getDepartureLatitude());
//        assertEquals(orderModel.getDestinationLongitude(), order.getDestinationLongitude());
//        assertEquals(orderModel.getDestinationLatitude(), order.getDestinationLatitude());
//        assertEquals(orderModel.getDescription(), order.getDescription());
//        assertEquals(orderModel.isNeedLoader(), order.getNeedLoader());
//        assertEquals(orderModel.getPaymentMethod(), order.getPaymentMethod());
    }

    @Test
    public void testGetFromPreCreateModel() {
//        PreCreatedOrderModel preCreatedOrderModel = new PreCreatedOrderModel();
//        preCreatedOrderModel.setUserId("60d5ec9af682fbd39a1a36a9");
//        preCreatedOrderModel.setCargoLength(10);
//        preCreatedOrderModel.setCargoWidth(10);
//        preCreatedOrderModel.setCargoHeight(10);
//        preCreatedOrderModel.setCargoWeight(10.0);
//        preCreatedOrderModel.setDepartureLatitude("48.3241422");
//        preCreatedOrderModel.setDepartureLongitude("35.5567891");
//        preCreatedOrderModel.setDestinationLatitude("48.3241422");
//        preCreatedOrderModel.setDestinationLongitude("48.3241422");
//        preCreatedOrderModel.setDescription("description");
//        preCreatedOrderModel.setNeedLoader(true);
//        preCreatedOrderModel.setPaymentMethod("paymentMethod");
//
//        OrderModel orderModel = OrderMapper.getFromPreCreateModel(preCreatedOrderModel);
//
//        assertEquals(new ObjectId(preCreatedOrderModel.getUserId()), orderModel.getUserId());
//        assertEquals(preCreatedOrderModel.getCargoLength(), orderModel.getCargoLength());
//        assertEquals(preCreatedOrderModel.getCargoWidth(), orderModel.getCargoWidth());
//        assertEquals(preCreatedOrderModel.getCargoHeight(), orderModel.getCargoHeight());
//        assertEquals(preCreatedOrderModel.getCargoWeight(), orderModel.getCargoWeight());
//        assertEquals(preCreatedOrderModel.getDepartureLongitude(), orderModel.getDepartureLongitude());
//        assertEquals(preCreatedOrderModel.getDepartureLatitude(), orderModel.getDepartureLatitude());
//        assertEquals(preCreatedOrderModel.getDestinationLongitude(), orderModel.getDestinationLongitude());
//        assertEquals(preCreatedOrderModel.getDestinationLatitude(), orderModel.getDestinationLatitude());
//        assertEquals(preCreatedOrderModel.getDescription(), orderModel.getDescription());
//        assertEquals(preCreatedOrderModel.isNeedLoader(), orderModel.isNeedLoader());
//        assertEquals(preCreatedOrderModel.getPaymentMethod(), orderModel.getPaymentMethod());
    }
}
