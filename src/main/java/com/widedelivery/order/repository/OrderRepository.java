package com.widedelivery.order.repository;

import com.widedelivery.order.entity.OrderModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, ObjectId> {
    // Запит для отримання кількості замовлень у певному часовому інтервалі для конкретного регіону
    @Query("{'createdAt': {$gte: ?0, $lt: ?1}, 'departureLongitude': {$near: [?2, ?3]}, 'departureLatitude': {$near: [?4, ?5]}}")
    long countByCreatedAtBetweenAndLocationNear(Instant start, Instant end, double longFrom, double longTo, double latFrom, double latTo);

    // Запит для отримання загальної кількості замовлень біля точки відправлення та доставки
    @Query("{'$or': [{'departureLongitude': {$near: [?0, ?1]}}, {'destinationLongitude': {$near: [?2, ?3]}}]}")
    long countAllByLocationNear(double depLong, double depLat, double destLong, double destLat);
}
