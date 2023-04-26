package com.vygos.getfoodorder.application.dto.input;

import jakarta.validation.constraints.*;
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
    @Positive
    private BigDecimal price = BigDecimal.ZERO;

    @NotNull
    @Positive
    private Integer quantity = 1;
}
