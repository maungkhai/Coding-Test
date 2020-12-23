package com.demo.codingtest.controller;

import com.demo.codingtest.model.Product;
import com.demo.codingtest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping("/product")
    public Mono<Product> addProduct(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/product")
    public Flux<Product> getAllProduct() {
        return service.findAll();
    }

    @GetMapping("/product/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/product")
    public Mono<ResponseEntity<Product>> updateProduct(@RequestBody Product product) {
        return service.findById(product.getId()).flatMap(product1 -> {
            product1.setName(product.getName());
            product1.setUnitPrice(product.getUnitPrice());
            return service.save(product1);
        }).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/product/{id}")
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable String id) {
        return service.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
