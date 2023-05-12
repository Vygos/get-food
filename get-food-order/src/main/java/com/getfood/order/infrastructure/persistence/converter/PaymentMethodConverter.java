package com.getfood.order.infrastructure.persistence.converter;

import com.getfood.order.core.domain.enums.PaymentMethod;
import com.vygos.core.enums.AbstractEnumConverter;

public class PaymentMethodConverter extends AbstractEnumConverter<PaymentMethod> {
    @Override
    public PaymentMethod convertToEntityAttribute(String value) {
        return PaymentMethod.getPaymentMethod(value);
    }
}
