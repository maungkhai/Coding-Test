package com.demo.codingtest.repository;

import com.demo.codingtest.model.OrderItems;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderItemsRepository extends ReactiveMongoRepository<OrderItems, String> {
}
