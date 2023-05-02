package com.vygos.getfoodorder.infrastructure.persistence.repository;

import com.vygos.getfoodorder.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
