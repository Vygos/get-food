package com.vygos.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Setter
public class OrderItems {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
