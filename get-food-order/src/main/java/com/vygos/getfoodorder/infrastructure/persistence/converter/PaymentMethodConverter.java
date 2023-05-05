package com.vygos.getfoodorder.infrastructure.persistence.converter;

import com.vygos.core.enums.AbstractEnumConverter;
import com.vygos.getfoodorder.core.domain.enums.PaymentMethod;

public class PaymentMethodConverter extends AbstractEnumConverter<PaymentMethod> {
    @Override
    public PaymentMethod convertToEntityAttribute(String value) {
        return PaymentMethod.getPaymentMethod(value);
    }
}
