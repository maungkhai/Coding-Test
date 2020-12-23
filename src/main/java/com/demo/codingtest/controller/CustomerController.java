package com.demo.codingtest.controller;

import com.demo.codingtest.model.Customer;
import com.demo.codingtest.service.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerServices services;


    @PostMapping("/customer")
    public Mono<Customer> addCustomer(@RequestBody Customer customer) {
        return services.save(customer);
    }

    @GetMapping("/customer")
    public Flux<Customer> getAllCustomer() {
        return services.findAll();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> getCustomer(@PathVariable String id) {
        return services.findById(id);
    }

    @PutMapping("/customer/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return services.findById(id).flatMap(cus -> {
            cus.setName(customer.getName());
            cus.setEmail(customer.getEmail());
            cus.setPhone(customer.getPhone());
            cus.setAddress(customer.getAddress());
            return services.save(cus);

        }).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("customer/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable String id) {
        return services.delete(id).map(
                ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
