package com.vygos.getfoodkitchen.core.domain.enums;

//import com.vygos.core.enums.BaseEnum;

import com.vygos.core.enums.BaseEnum;

import java.util.stream.Stream;

public enum TicketStatus implements BaseEnum {
    COURIER_VERIFY_PENDING(1, "COURIER_VERIFY_PENDING"),
    READY_TO_ACCEPTANCE(2, "READY_TO_ACCEPTANCE"),
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

    public static TicketStatus getTicketStatus(String value) {
        return Stream.of(TicketStatus.values())
            .filter(v -> v.value.equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
