package com.getfood.courier.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Address {
    private UUID id;
    private String street;
    private String city;
    private ZipCode zipCode;
    private String country;
}
