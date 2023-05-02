package com.vygos.getfoodkitchen.infrastructure.persistence.entity;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ADDRESS_ID")
    private UUID id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "COUNTRY")
    private String country;
}
