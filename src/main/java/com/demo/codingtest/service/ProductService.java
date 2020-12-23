package com.demo.codingtest.service;

import com.demo.codingtest.model.Product;
import com.demo.codingtest.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

}
