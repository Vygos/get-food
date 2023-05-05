package com.vygos.getfoodkitchen.infrastructure.persistence.converter;

import com.vygos.core.enums.AbstractEnumConverter;
import com.vygos.core.enums.BaseEnum;
import com.vygos.getfoodkitchen.core.domain.enums.TicketStatus;

public class TicketStatusConverter extends AbstractEnumConverter {
    @Override
    public BaseEnum convertToEntityAttribute(String value) {
        return TicketStatus.getTicketStatus(value);
    }
}
