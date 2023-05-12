package com.getfood.kitchen.infrastructure.adapter;

import com.getfood.kitchen.core.ports.outgoing.RestaurantRepositoryGateway;
import com.getfood.kitchen.infrastructure.mapper.RestaurantMapper;
import com.getfood.kitchen.infrastructure.persistence.repository.RestaurantRepository;
import com.getfood.kitchen.core.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class RestaurantRepositoryAdapter implements RestaurantRepositoryGateway {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper mapper;

    @Override
    public Optional<Restaurant> findById(UUID id) {
        return this.restaurantRepository.findById(id).map(mapper::toDomainOpen);
    }
}
