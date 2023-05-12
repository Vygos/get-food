package com.getfood.kitchen.infrastructure.persistence.converter;

import com.vygos.core.enums.AbstractEnumConverter;
import com.getfood.kitchen.core.domain.enums.TicketStatus;

public class TicketStatusConverter extends AbstractEnumConverter<TicketStatus> {

    @Override
    public TicketStatus convertToEntityAttribute(String value) {
        return TicketStatus.getTicketStatus(value);
    }

}
