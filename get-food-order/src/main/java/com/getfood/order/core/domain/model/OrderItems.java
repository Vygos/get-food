package com.getfood.order.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class OrderItems {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private Integer quantity = 1;

    public BigDecimal calculatePrice() {
        return price.multiply(BigDecimal.valueOf(quantity.longValue()));
    }

}
