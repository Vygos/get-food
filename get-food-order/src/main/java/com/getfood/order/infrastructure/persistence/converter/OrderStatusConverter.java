package com.getfood.order.infrastructure.persistence.converter;

import com.getfood.order.core.domain.enums.OrderStatus;
import com.vygos.core.enums.AbstractEnumConverter;

public class OrderStatusConverter extends AbstractEnumConverter<OrderStatus> {

    @Override
    public OrderStatus convertToEntityAttribute(String value) {
        return OrderStatus.getOrderStatus(value);
    }
}
