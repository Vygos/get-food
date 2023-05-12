package com.getfood.kitchen.core.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Restaurant {

    private UUID id;
    private String name;
    private String register;
    private String openAt;
    private String closeAt;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Boolean open;

    private Address address;

    public Boolean isOpen() {
        return this.open;
    }
    public void setIsOpen(Boolean open) {
        this.open = open;
    }
}
