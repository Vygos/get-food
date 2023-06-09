package com.getfood.order.core.domain.enums;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum PaymentMethod implements BaseEnum {
    CREDIT_CARD(1, "CREDIT_CARD"),
    TRANSFER(2, "TRANSFER");

    private final Integer id;
    private final String name;

    PaymentMethod(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getValue() {
        return this.name;
    }

    public static PaymentMethod getPaymentMethod(String value) {
        return Stream.of(PaymentMethod.values())
            .filter(v -> v.getValue().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
