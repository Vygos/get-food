package com.vygos.core.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

public abstract class AbstractEnumConverter<E extends BaseEnum> implements AttributeConverter<E, String> {

    @Override
    public String convertToDatabaseColumn(E baseEnum) {
        if (baseEnum == null) {
            return null;
        }
        return baseEnum.getValue();
    }

}
