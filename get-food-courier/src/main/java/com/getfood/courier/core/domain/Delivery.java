package com.getfood.courier.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class Delivery {

    private UUID id;
    private UUID userId;
    private ZonedDateTime deliveryAt;
    private CourierUser courierUser;
    private Address source;
    private Address destination;

}
