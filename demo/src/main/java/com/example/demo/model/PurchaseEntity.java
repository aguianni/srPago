package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String name;

    private String lastName;

    private String cardNumber;

    private Integer expirationDateYear;

    private String expirationDateMonth;

    private Integer gasType;

    private Double amount;

    private String gasStation;

    private String sellerName;

    private Double price;
}
