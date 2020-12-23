package com.demo.codingtest.controller;


import com.demo.codingtest.model.OrderItems;
import com.demo.codingtest.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderItemController {

    private final OrderItemsService service;

    @GetMapping("/order/item")
    public Flux<OrderItems> getAllOrderItem() {
        return service.findAll();
    }

    @GetMapping("/order/item/{id}")
    public Mono<OrderItems> getOrderItem(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/order/item")
    public Mono<OrderItems> addOrderItem(@RequestBody OrderItems items) {
        return service.save(items);
    }

    @PutMapping("order/item")
    public Mono<ResponseEntity<OrderItems>> updateOrder(@RequestBody OrderItems orderItems) {
        return service.findById(orderItems.getId()).flatMap(updateItem -> {
            updateItem.setQuantity(orderItems.getQuantity());
            updateItem.setTotal(orderItems.getTotal());
            updateItem.setOrder(orderItems.getOrder());
            updateItem.setProduct(orderItems.getProduct());
            return service.save(orderItems);
        }).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("order/item/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return service.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
