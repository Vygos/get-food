package com.getfood.kitchen.infrastructure.adapter;

import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.core.ports.outgoing.TicketRepositoryGateway;
import com.getfood.kitchen.infrastructure.mapper.TicketMapper;
import com.getfood.kitchen.infrastructure.persistence.entity.TicketEntity;
import com.getfood.kitchen.infrastructure.persistence.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TicketRepositoryAdapter implements TicketRepositoryGateway {
    private final TicketRepository ticketRepository;
    private final TicketMapper mapper;

    public Ticket save(Ticket ticket) {
        TicketEntity ticketEntity = mapper.toEntity(ticket);
        ticketEntity = this.ticketRepository.save(ticketEntity);
        return mapper.toDomain(ticketEntity);
    }
}
