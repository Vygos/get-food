package com.getfood.courier.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "DELIVERY_COURIER_USER")
public class CourierUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "DELIVERY_COURIER_USER_ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGISTER_NUMBER")
    private String registerNumber;

    @Column(name = "BIRTHDAY_DATE")
    private LocalDate birthdayDate;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "ONLINE")
    private Boolean online;

    @Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private ZonedDateTime updatedAt;
}
