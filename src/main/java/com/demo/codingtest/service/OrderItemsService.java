package com.demo.codingtest.service;

import com.demo.codingtest.model.OrderItems;
import com.demo.codingtest.repository.OrderItemsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderItemsService {

    private final OrderItemsRepository repository;

    public OrderItemsService(OrderItemsRepository repository) {
        this.repository = repository;
    }

    public Flux<OrderItems> findAll() {
        return repository.findAll();
    }

    public Mono<OrderItems> findById(String id) {
        return repository.findById(id);
    }

    public Mono<OrderItems> save(OrderItems orderItems) {
        return repository.save(orderItems);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
