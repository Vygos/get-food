package com.vygos.getfoodkitchen.infrastructure.persistence.entity;

import com.vygos.getfoodkitchen.core.domain.model.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@Table(name = "RESTAURANT")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RESTAURANT_ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGISTER")
    private String register;

    @Column(name = "OPEN_AT")
    private String openAt;

    @Column(name = "CLOSE_AT")
    private String closeAt;

    @Column(name = "OPEN")
    private Boolean open;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;
}
