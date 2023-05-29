package com.getfood.kitchen.infrastructure.adapter;

import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.core.ports.outgoing.TicketRepositoryGateway;
import com.getfood.kitchen.infrastructure.mapper.TicketMapper;
import com.getfood.kitchen.infrastructure.persistence.entity.TicketEntity;
import com.getfood.kitchen.infrastructure.persistence.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    public Optional<Ticket> findByOrderId(UUID orderId) {
        return this.ticketRepository.findByOrderId(orderId).map(mapper::toDomain);
    }

    @Override
    public Optional<Ticket> findById(UUID id) {
        return this.ticketRepository.findById(id).map(mapper::toDomain);
    }

}
