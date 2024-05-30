package com.widedelivery.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.time.OffsetDateTime;
import java.util.Optional;

@Configuration
@EnableMongoAuditing
//        (dateTimeProviderRef = "auditingDateTimeProvider")
public class MongoConfig {

//    public @Bean com.mongodb.client.MongoClient mongoClient() {
//        return com.mongodb.client.MongoClients.create("mongodb://root:example@localhost:27017/order-service?authSource=admin");
//    }
//
//    @Bean(name = "auditingDateTimeProvider")
//    public DateTimeProvider dateTimeProvider() {
//        return () -> Optional.of(OffsetDateTime.now());
//    }

}
