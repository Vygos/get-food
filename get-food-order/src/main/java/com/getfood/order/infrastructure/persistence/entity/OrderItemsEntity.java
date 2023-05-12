package com.getfood.order.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ORDER_ITEM_ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

}
