package com.vygos.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class Restaurant {
    private UUID restaurantId;
    private String name;
}
