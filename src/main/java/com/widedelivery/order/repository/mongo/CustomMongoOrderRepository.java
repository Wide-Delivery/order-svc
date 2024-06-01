package com.widedelivery.order.repository.mongo;

import com.widedelivery.order.entity.OrderModel;
import com.widedelivery.order.entity.OrderStatus;
import com.widedelivery.order.repository.CustomOrderRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Component
public class CustomMongoOrderRepository implements CustomOrderRepository {

    private final MongoTemplate mongoTemplate;

    public CustomMongoOrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<OrderModel> searchOrders(Map<String, Object> searchParams, Pageable pageable) {
        Query query = new Query();

        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            if ("id".equals(entry.getKey())) {
                query.addCriteria(Criteria.where(entry.getKey()).is(new ObjectId(entry.getValue().toString())));
            } else if ("userId".equals(entry.getKey()) || "driverId".equals(entry.getKey())) {
                query.addCriteria(Criteria.where(entry.getKey()).is(new ObjectId(entry.getValue().toString())));
            } else if ("status".equals(entry.getKey())) {
                query.addCriteria(Criteria.where(entry.getKey()).is(OrderStatus.valueOf(entry.getValue().toString())));
            } else if (entry.getValue() instanceof Number || entry.getValue() instanceof Boolean || entry.getValue() instanceof String) {
                query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
            } else if (entry.getValue() instanceof Instant) {
                query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
            }
        }

        long count = mongoTemplate.count(query, OrderModel.class);
        List<OrderModel> orders = mongoTemplate.find(query.with(pageable), OrderModel.class);

        return new PageImpl<>(orders, pageable, count);
    }
}
