package com.demo.codingtest.controller;

import com.demo.codingtest.model.Order;
import com.demo.codingtest.model.Status;
import com.demo.codingtest.service.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderServices services;

    @GetMapping("/order")
    public Flux<Order> getAllOrder() {
        return services.findAll();
    }

    @GetMapping("/order/{id}")
    public Mono<Order> getOrder(@PathVariable String id) {
        return services.findById(id);
    }

    @PostMapping("/order")
    public Mono<Order> addOrder(@RequestBody Order order) {
        return services.save(order);
    }

    @PutMapping("/order")
    public Mono<ResponseEntity<Order>> updateOrder(@RequestBody Order order) {
        return services.findById(order.getId()).flatMap(order1 -> {
            order1.setOrderno(order.getOrderno());
            order1.setStatus(order.getStatus());
            order1.setCustomer(order.getCustomer());
            return services.save(order1);
        }).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/order/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return services.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
