package com.vygos.getfoodkitchen.core.domain.enums;

//import com.vygos.core.enums.BaseEnum;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum TicketStatus implements BaseEnum {
    PENDING(1, "PENDING"),
    COURIER_VERIFY_PENDING(2, "COURIER_VERIFY_PENDING"),
    ACCEPTED(3, "ACCEPTED"),
    PREPARING(4, "PREPARING"),
    REJECTED(5, "REJECTED"),
    PICK_UP_PENDING(6, "PICK_UP_PENDING"),
    DELIVERY_PENDING(7, "DELIVERY_PENDING"),
    DELIVERED(8, "DELIVERED");

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
