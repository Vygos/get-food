package com.vygos.getfoodorder.core.domain.enums;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum OrderStatus implements BaseEnum {
    PENDING(1, "PENDING"),
    COURIER_VERIFY_PENDING(1, "COURIER_VERIFY_PENDING"),
    ACCEPTED(2, "PAYMENT_PENDING"),
    PREPARING(3, "PREPARING"),
    PICK_UP_PENDING(4, "PICK_UP_PENDING"),
    DELIVERED_PENDING(5, "DELIVERY_PENDING"),
    DELIVERED(5, "APPROVED");


    private final Integer id;
    private final String value;

    OrderStatus(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public BaseEnum getInstance(String value) {
        return Stream.of(OrderStatus.values())
            .filter(v -> v.value.equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
