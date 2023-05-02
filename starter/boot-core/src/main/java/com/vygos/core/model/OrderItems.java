package com.vygos.core.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
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
