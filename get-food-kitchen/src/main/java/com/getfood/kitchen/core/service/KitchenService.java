package com.getfood.kitchen.core.service;

import com.getfood.kitchen.core.domain.model.Restaurant;
import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.core.ports.outgoing.OrderCommandGateway;
import com.getfood.kitchen.core.ports.outgoing.RestaurantRepositoryGateway;
import com.getfood.kitchen.core.ports.outgoing.TicketEventGateway;
import com.getfood.kitchen.core.ports.outgoing.TicketRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class KitchenService {
    private final TicketRepositoryGateway ticketRepository;
    private final RestaurantRepositoryGateway restaurantRepository;
    private final OrderCommandGateway orderCommandGateway;
    private final TicketEventGateway ticketEventGateway;

    @Transactional
    public void saveTicket(Ticket ticket) {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(ticket.getRestaurant().getId());

        if (optionalRestaurant.isEmpty()) {
            ticketRepository.save(ticket);
            sendOrderRejectCommand(ticket);
            return;
        }

        var restaurant = optionalRestaurant.get();
        if (!restaurant.isOpen()) {
            ticketRepository.save(ticket);
            sendOrderRejectCommand(ticket);
            return;
        }

        ticket.changeToCourierVerifyPending();
        var ticketPersisted = ticketRepository.save(ticket);
        orderCommandGateway.send(ticketPersisted.toCreateTicketReply());
    }

    @Transactional
    public Ticket updateStatus(Ticket ticket) {
        Optional<Ticket> ticketOptional = this.ticketRepository.findByOrderId(ticket.getOrderId());

        if (ticketOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        Ticket ticketPersisted = ticketOptional.get();
        ticketPersisted.setStatus(ticket.getStatus());
        this.ticketRepository.save(ticketPersisted);
        return ticketPersisted;
    }

    private void sendOrderRejectCommand(Ticket ticket) {
        ticket.changeToRejected();
        this.orderCommandGateway.send(ticket.toOrderRejected());
    }

    public void updateReadyToAcceptance(Ticket ticket) {
        this.updateStatus(ticket);
    }

    public void accept(UUID ticketId) {
        Optional<Ticket> ticketOptional = this.ticketRepository.findById(ticketId);

        if (ticketOptional.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        Ticket ticket = ticketOptional.get();
        ticket.changeToAccepted();

        updateStatus(ticketOptional.get());
        this.ticketEventGateway.send(ticket.toAcceptedTicket());
    }
}
