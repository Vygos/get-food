package com.vygos.core.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

public class AbstractEnumConverter implements AttributeConverter<BaseEnum, String> {
    private BaseEnum baseEnum;

    @Override
    public String convertToDatabaseColumn(BaseEnum baseEnum) {
        if (baseEnum == null) {
            return null;
        }
        this.baseEnum = baseEnum;
        return baseEnum.getValue();
    }

    @Override
    public BaseEnum convertToEntityAttribute(String s) {
        return this.baseEnum.getInstance(s);
    }
}
