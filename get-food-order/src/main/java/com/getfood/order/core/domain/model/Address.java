package com.getfood.order.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Address {

    private UUID id;
    private String street;
    private String city;
    private String zipCode;
    private String country;
}
