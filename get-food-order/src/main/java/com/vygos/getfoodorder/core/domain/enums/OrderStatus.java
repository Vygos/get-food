package com.vygos.getfoodorder.core.domain.enums;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum OrderStatus implements BaseEnum {
    PENDING(1, "PENDING"),
    COURIER_VERIFY_PENDING(2, "COURIER_VERIFY_PENDING"),
    ACCEPTED(3, "PAYMENT_PENDING"),
    PREPARING(4, "PREPARING"),
    PICK_UP_PENDING(5, "PICK_UP_PENDING"),
    DELIVERED_PENDING(6, "DELIVERY_PENDING"),
    DELIVERED(7, "APPROVED");


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
        return getOrderStatus(value);
    }

    public static OrderStatus getOrderStatus(String value) {
        return Stream.of(OrderStatus.values())
            .filter(v -> v.value.equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
