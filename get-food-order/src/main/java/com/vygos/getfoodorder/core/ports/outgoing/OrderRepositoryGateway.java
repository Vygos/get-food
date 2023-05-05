package com.vygos.getfoodorder.core.ports.outgoing;

import com.vygos.getfoodorder.core.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryGateway {

    Order save(Order order);

    Order update(Order order);

    Optional<Order> findById(UUID id);
}
