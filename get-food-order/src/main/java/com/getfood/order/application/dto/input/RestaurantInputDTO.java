package com.getfood.order.application.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RestaurantInputDTO {

    private UUID id;


    @NotNull
    private UUID restaurantId;

    @NotBlank
    private String name;

    @NotBlank
    private String registrationNumber;
}
