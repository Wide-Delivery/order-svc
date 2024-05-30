package com.widedelivery.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSvcApplication.class, args);
//        try {
//            OrderServer server = new OrderServer(3006);
//            server.start();
//            server.blockUntilShutdown();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("[souted]");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("[souted twice]");
    }

}
