package com.example.demo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class InfoRQ{

    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String lastName;

    @NotNull @NotEmpty
    private String cardNumber;

    @NotNull
    private Integer expirationDateYear;

    @NotNull @NotEmpty
    private String expirationDateMonth;

    @NotNull
    private Integer gasType;

    @NotNull @Positive
    private Double amount;

    @NotNull @NotEmpty
    private String gasStation;

    @NotNull @NotEmpty
    private String sellerName;
}
