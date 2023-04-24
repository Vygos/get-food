package com.vygos.getfoodorder.infrastructure.persistence.repository;

import com.vygos.getfoodorder.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
