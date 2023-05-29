package com.getfood.kitchen.core.ports.outgoing;

import com.getfood.kitchen.core.domain.model.Ticket;

import java.util.Optional;
import java.util.UUID;

public interface TicketRepositoryGateway {
    Ticket save(Ticket ticket);

    Optional<Ticket> findByOrderId(UUID orderId);

    Optional<Ticket> findById(UUID id);
}
