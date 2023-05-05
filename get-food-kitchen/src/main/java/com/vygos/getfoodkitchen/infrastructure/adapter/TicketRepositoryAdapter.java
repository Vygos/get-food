package com.vygos.getfoodkitchen.infrastructure.adapter;

import com.vygos.getfoodkitchen.core.domain.model.Ticket;
import com.vygos.getfoodkitchen.core.ports.outgoing.TicketRepositoryGateway;
import com.vygos.getfoodkitchen.infrastructure.mapper.TicketMapper;
import com.vygos.getfoodkitchen.infrastructure.persistence.entity.TicketEntity;
import com.vygos.getfoodkitchen.infrastructure.persistence.repository.TicketRepository;
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
