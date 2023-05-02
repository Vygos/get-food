package com.vygos.getfoodkitchen.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Item {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private Integer quantity = 1;
}
