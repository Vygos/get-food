package com.vygos.getfoodkitchen.core.ports.outgoing;

import com.vygos.getfoodkitchen.core.domain.model.Ticket;
import com.vygos.getfoodkitchen.infrastructure.persistence.entity.TicketEntity;

public interface TicketRepositoryGateway {
    Ticket save(Ticket ticket);
}
