package com.getfood.order.infrastructure.persistence.repository;

import com.getfood.order.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    @Override
    @Query("SELECT order from OrderEntity order " +
        " JOIN order.source JOIN order.destination JOIN order.restaurant" +
        " JOIN FETCH order.items WHERE order.id = :id ")
    Optional<OrderEntity> findById(UUID id);
}
