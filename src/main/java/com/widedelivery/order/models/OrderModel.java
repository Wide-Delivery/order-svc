package com.widedelivery.order.models;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.proto.Order;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class OrderModel {

//    @NonNull
    @Id
    private ObjectId id;

    @NonNull
    @Setter
    private String userId; // TODO should be object id

    @Setter
    private String driverId;

    @Setter
    @Field
    private OrderStatus status = OrderStatus.CREATED;

    @Setter
    private String currentLocation = "N/A";

//    @Setter
//    private String cargoType; // we have dimensions so dont need type

    @Setter
    private double cargoLength;

    @Setter
    private double cargoWidth;

    @Setter
    private double cargoHeight;

    @Setter
    private double cargoWeight;

    @Setter
    private String departureLongitude;

    @Setter
    private String departureLatitude;

    @Setter
    private Timestamp departureTime;

    @Setter
    private String destinationLongitude;

    @Setter
    private String destinationLatitude;

    @Setter
    private Timestamp destinationTime;

    @Setter
    private String description;

    @Setter
    private boolean needLoader;

    @Setter
    private String paymentMethod;

    @CreatedDate
    @Setter
    private Instant createdAt;

    @LastModifiedDate
    @Setter
    private Instant updatedAt;

    @Version
    private Integer version;


    public Order getGrpcMessage() {
        Order message = Order
                .newBuilder()
                .setId(this.id.toString())
                .setUserId(this.userId)
                .setCargoLength(this.cargoLength)
                .setCargoWidth(this.cargoWidth)
                .setCargoHeight(this.cargoHeight)
                .setDepartureLongitude(this.departureLongitude)
                .setDepartureLatitude(this.departureLatitude)
                .setDestinationLongitude(this.destinationLongitude)
                .setDestinationLatitude(this.destinationLatitude)
                .setDescription(this.description)
                .setNeedLoader(this.needLoader)
                .setPaymentMethod(this.paymentMethod)
                .setCreatedAt(Timestamp.newBuilder().setSeconds(
                        this.createdAt.getEpochSecond()).build()
                )
                .setUpdatedAt(Timestamp.newBuilder().setSeconds(
                        this.updatedAt.getEpochSecond()).build())
                .build();
        // todo need statement to fill times
        if (this.destinationTime != null) {
            message = message.toBuilder().setDestinationTime(this.destinationTime).build();
        }
        if (this.departureTime != null) {
            message = message.toBuilder().setDepartureTime(this.departureTime).build();
        }
        return message;
    }

    public static OrderModel getFromPreCreateModel(PreCreatedOrderModel preCreatedOrderModel) {
        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(preCreatedOrderModel.getUserId());
        orderModel.setCargoLength(preCreatedOrderModel.getCargoLength());
        orderModel.setCargoWidth(preCreatedOrderModel.getCargoWidth());
        orderModel.setCargoHeight(preCreatedOrderModel.getCargoHeight());
        orderModel.setCargoWidth(preCreatedOrderModel.getCargoWeight());
        orderModel.setDepartureLongitude(preCreatedOrderModel.getDepartureLongitude());
        orderModel.setDepartureLatitude(preCreatedOrderModel.getDepartureLatitude());
        orderModel.setDepartureTime(preCreatedOrderModel.getDepartureTime());
        orderModel.setDestinationLongitude(preCreatedOrderModel.getDestinationLongitude());
        orderModel.setDestinationLatitude(preCreatedOrderModel.getDestinationLatitude());
        orderModel.setDestinationTime(preCreatedOrderModel.getDestinationTime());
        orderModel.setDescription(preCreatedOrderModel.getDescription());
        orderModel.setNeedLoader(preCreatedOrderModel.isNeedLoader());
        orderModel.setPaymentMethod(preCreatedOrderModel.getPaymentMethod());
        return orderModel;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", cargoLength=" + cargoLength +
                ", cargoWidth=" + cargoWidth +
                ", cargoHeight=" + cargoHeight +
                ", cargoWeight=" + cargoWeight +
                ", departureLongitude='" + departureLongitude + '\'' +
                ", departureLatitude='" + departureLatitude + '\'' +
                ", departureTime=" + departureTime +
                ", destinationLongitude='" + destinationLongitude + '\'' +
                ", destinationLatitude='" + destinationLatitude + '\'' +
                ", destinationTime=" + destinationTime +
                ", description='" + description + '\'' +
                ", needLoader=" + needLoader +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
