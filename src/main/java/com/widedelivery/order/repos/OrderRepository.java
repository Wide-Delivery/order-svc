package com.widedelivery.order.repos;

import com.widedelivery.order.models.OrderModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, ObjectId> {
//    @Query("{id: ObjectId('?0')}")
//    OrderModel findById(ObjectId id);
//    OrderModel findByUserId(String userId);
}
