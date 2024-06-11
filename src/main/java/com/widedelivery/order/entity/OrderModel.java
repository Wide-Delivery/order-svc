package com.widedelivery.order.entity;

import com.mongodb.client.model.geojson.LineString;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document(collection = "orders")
public class OrderModel {

    @Id
    private ObjectId id;

    @NonNull
    @Setter
    private ObjectId userId;

    @Setter
    private String driverId;

    @Setter
    @Field
    private OrderStatus status = OrderStatus.CREATED;

    @Setter
    private String currentLocation = "N/A";

    @Setter
    private double cargoLength;

    @Setter
    private double cargoWidth;

    @Setter
    private double cargoHeight;

    @Setter
    private double cargoWeight;

    @Setter
    private String cargoType;

    @Setter
    private String departureLongitude;

    @Setter
    private String departureLatitude;

    @Setter
    private Instant departureTime;

    @Setter
    private String destinationLongitude;

    @Setter
    private String destinationLatitude;

    @Setter
    private Instant destinationTime;

    @Setter
    private String routeEncoded;

    @Setter
    @GeoSpatialIndexed(name = "route_index")
    private LineString route;

    @Setter
    private String distance;

    @Setter
    private String duration;

    @Setter
    private String startAddressName;

    @Setter
    private String endAddressName;

    @Setter
    private String description;

    @Setter
    private boolean needLoader;

    @Setter
    private double price;

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
}
