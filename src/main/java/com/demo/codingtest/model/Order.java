package com.demo.codingtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Getter
@Setter
@Data
@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private long orderno;
    private Date orderDate = new Date();
    private Status status;
    private Customer customer;

}
