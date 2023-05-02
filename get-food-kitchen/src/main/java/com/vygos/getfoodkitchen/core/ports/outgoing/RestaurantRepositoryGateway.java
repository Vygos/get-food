package com.vygos.getfoodkitchen.core.ports.outgoing;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepositoryGateway {
    Optional<Restaurant> findById(UUID id);
}
