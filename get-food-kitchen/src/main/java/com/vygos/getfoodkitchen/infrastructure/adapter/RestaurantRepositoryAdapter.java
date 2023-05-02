package com.vygos.getfoodkitchen.infrastructure.adapter;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
import com.vygos.getfoodkitchen.core.ports.outgoing.RestaurantRepositoryGateway;
import com.vygos.getfoodkitchen.infrastructure.mapper.RestaurantMapper;
import com.vygos.getfoodkitchen.infrastructure.persistence.repository.RestaurantRepository;
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
        return this.restaurantRepository.findById(id).map(mapper::toDomain);
    }
}
