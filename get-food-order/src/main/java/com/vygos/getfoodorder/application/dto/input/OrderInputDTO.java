package com.vygos.getfoodorder.application.dto.input;

import com.vygos.getfoodorder.core.domain.enums.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class OrderInputDTO {

    private UUID id;

    @NotNull
    private UUID userId;

    private String preparationInstructions;

    @NotNull
    private PaymentMethod paymentMethod;

    private BigDecimal total;

    @Valid
    @NotNull
    private RestaurantInputDTO restaurant;

    @Valid
    @NotNull
    private AddressInputDTO source;

    @Valid
    @NotNull
    private AddressInputDTO destination;

    @Valid
    @NotNull
    List<OrderItemsInputDTO> items = new ArrayList<>();
}
