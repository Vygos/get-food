package com.vygos.core.model;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Restaurant {
    private UUID restaurantId;
    private String name;
}
