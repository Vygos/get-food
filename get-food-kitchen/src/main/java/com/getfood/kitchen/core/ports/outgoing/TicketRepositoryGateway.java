package com.getfood.kitchen.core.ports.outgoing;

import com.getfood.kitchen.core.domain.model.Ticket;

public interface TicketRepositoryGateway {
    Ticket save(Ticket ticket);
}
