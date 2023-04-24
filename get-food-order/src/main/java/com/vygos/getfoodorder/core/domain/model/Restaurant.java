package com.vygos.getfoodorder.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Restaurant {

    private UUID id;
    private UUID restaurantId;
    private String name;
    private String registrationNumber;
}
