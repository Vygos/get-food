package com.vygos.getfoodorder.infrastructure.persistence.converter;

import com.vygos.core.enums.AbstractEnumConverter;
import com.vygos.getfoodorder.core.domain.enums.OrderStatus;

public class OrderStatusConverter extends AbstractEnumConverter<OrderStatus> {

    @Override
    public OrderStatus convertToEntityAttribute(String value) {
        return OrderStatus.getOrderStatus(value);
    }
}
