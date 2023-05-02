package com.vygos.getfoodkitchen.infrastructure.persistence.repository;

import com.vygos.getfoodkitchen.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, UUID> {
}
