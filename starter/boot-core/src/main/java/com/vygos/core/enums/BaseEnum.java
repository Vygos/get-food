package com.vygos.core.enums;

public interface BaseEnum {
    String getName();

    String getValue();

    BaseEnum getInstance(String value);

}
