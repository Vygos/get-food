package com.getfood.kitchen.infrastructure.persistence.repository;

import com.getfood.kitchen.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, UUID> {
}
