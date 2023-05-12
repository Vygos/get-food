package com.getfood.kitchen.core.ports.outgoing;

import com.getfood.kitchen.core.domain.model.Restaurant;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepositoryGateway {
    Optional<Restaurant> findById(UUID id);
}
