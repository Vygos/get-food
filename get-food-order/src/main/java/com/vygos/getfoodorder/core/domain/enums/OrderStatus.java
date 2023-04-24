package com.vygos.getfoodorder.core.domain.enums;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum OrderStatus implements BaseEnum {
    PENDING(1, "Pending", "PENDING"),
    PAYMENT_PENDING(2, "Payment Pending", "PAYMENT_PENDING"),
    APPROVED(2,"Approved","APPROVED");


    private final Integer id;
    private final String name;
    private final String value;

    OrderStatus(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
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
