package com.demo.codingtest.service;

import com.demo.codingtest.model.Customer;
import com.demo.codingtest.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServices {
    
    private final CustomerRepository repository;

    public CustomerServices(CustomerRepository repository) {
        this.repository = repository;
    }

    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    public Mono<Customer> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
