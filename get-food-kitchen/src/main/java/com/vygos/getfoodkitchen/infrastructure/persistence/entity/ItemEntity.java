package com.vygos.getfoodkitchen.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ITEM_ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "QUANTITY")
    private Integer quantity = 1;
}
