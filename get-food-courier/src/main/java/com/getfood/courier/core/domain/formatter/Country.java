package com.getfood.courier.core.domain.formatter;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Country {
    BRAZIL("BRAZIL"),
    ARGENTINA("ARGENTINA");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public static Country getInstance(String name) {
        return Arrays.stream(Country.values()).filter(c -> c.name.equals(name))
            .findFirst()
            .orElseThrow(() ->  new IllegalArgumentException("Country which you provide isn't exist"));
    }
}
