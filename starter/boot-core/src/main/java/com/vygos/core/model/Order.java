package com.vygos.core.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order {
    private UUID id;
    private UUID userId;
    private String status;
    private String preparationInstructions;
    private BigDecimal total;
    private Restaurant restaurant;
    private List<OrderItems> items;

}
