package com.getfood.courier.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "DELIVERY")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "DELIVERY_ID")
    private UUID id;

    @Column(name = "USER_ID")
    private UUID userId;

    @Column(name = "ORDER_ID")
    private UUID orderId;

    @OneToOne
    @JoinColumn(name = "DELIVERY_COURIER_USER_ID")
    private CourierUserEntity courierUser;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_SOURCE_ID")
    private AddressEntity source;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_DESTINATION_ID")
    private AddressEntity destination;


}
