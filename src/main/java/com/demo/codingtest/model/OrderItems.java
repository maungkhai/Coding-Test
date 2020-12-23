package com.demo.codingtest.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Setter
@Getter
@Document(collection = "order_item")
public class OrderItems {

    @Id
    private String id;
    private int quantity;
    private double total;
    private Order order;
    private List<Product> product;

}
