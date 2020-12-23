package com.demo.codingtest.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

}
