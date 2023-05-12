package com.getfood.kitchen.core.service;

import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.core.ports.outgoing.OrderCommandGateway;
import com.getfood.kitchen.core.ports.outgoing.RestaurantRepositoryGateway;
import com.getfood.kitchen.core.domain.model.Restaurant;
import com.getfood.kitchen.core.ports.outgoing.TicketRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KitchenService {
    private final TicketRepositoryGateway ticketRepository;
    private final RestaurantRepositoryGateway restaurantRepository;
    private final OrderCommandGateway orderCommandGateway;

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
        orderCommandGateway.send(ticketPersisted.toAcceptOrder());
    }

    private void sendOrderRejectCommand(Ticket ticket) {
        ticket.changeToRejected();
        this.orderCommandGateway.send(ticket.toOrderRejected());
    }

}