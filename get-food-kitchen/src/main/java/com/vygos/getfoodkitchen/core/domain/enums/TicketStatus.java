package com.vygos.getfoodkitchen.core.domain.enums;

//import com.vygos.core.enums.BaseEnum;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum TicketStatus implements BaseEnum {
    COURIER_VERIFY_PENDING(1, "COURIER_VERIFY_PENDING"),
    ACCEPTED(2, "ACCEPTED"),
    PREPARING(3, "PREPARING"),
    REJECTED(4, "REJECTED"),
    PICK_UP_PENDING(5, "PICK_UP_PENDING"),
    DELIVERY_PENDING(6, "DELIVERY_PENDING"),
    DELIVERED(7, "DELIVERED");

    private final Integer id;
    private final String value;

    TicketStatus(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public BaseEnum getInstance(String value) {
        return getTicketStatus(value);
    }

    public static TicketStatus getTicketStatus(String value) {
        return Stream.of(TicketStatus.values())
            .filter(v -> v.value.equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
