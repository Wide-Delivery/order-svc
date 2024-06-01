package com.widedelivery.order.repository;

import com.widedelivery.order.entity.OrderModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, ObjectId> {

}
