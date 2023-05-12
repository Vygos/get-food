package com.getfood.order.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ORDER_RESTAURANT")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ORDER_RESTAURANT_ID")
    private UUID id;

    @Column(name = "RESTAURANT_ID")
    private UUID restaurantId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMPANY_REGISTRATION_NUMBER")
    private String registrationNumber;
}
