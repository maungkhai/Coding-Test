package com.demo.codingtest.service;

import com.demo.codingtest.model.Order;
import com.demo.codingtest.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServices {

    private final OrderRepository repository;

    public OrderServices(OrderRepository repository) {
        this.repository = repository;
    }

    public Flux<Order> findAll() {
        return repository.findAll();
    }

    public Mono<Order> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Order> save(Order order) {

        return repository.save(order);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
