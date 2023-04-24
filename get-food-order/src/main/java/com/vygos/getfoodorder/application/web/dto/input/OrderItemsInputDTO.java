package com.vygos.getfoodorder.application.web.dto.input;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class OrderItemsInputDTO {

    private UUID id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @NegativeOrZero
    private BigDecimal price = BigDecimal.ZERO;

    @NotNull
    @NegativeOrZero
    private Integer quantity = 1;
}
