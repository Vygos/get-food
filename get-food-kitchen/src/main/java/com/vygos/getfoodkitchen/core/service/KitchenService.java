package com.vygos.getfoodkitchen.core.service;

import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
import com.vygos.getfoodkitchen.core.domain.model.Ticket;
import com.vygos.getfoodkitchen.core.ports.outgoing.OrderCommandGateway;
import com.vygos.getfoodkitchen.core.ports.outgoing.RestaurantRepositoryGateway;
import com.vygos.getfoodkitchen.core.ports.outgoing.TicketRepositoryGateway;
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
            sendOrderRejectCommand(ticket);
            ticketRepository.save(ticket);
            return;
        }

        var restaurant = optionalRestaurant.get();
        if (!restaurant.isOpen()) {
            sendOrderRejectCommand(ticket);
            ticketRepository.save(ticket);
            return;
        }

        ticket.pending();
        ticketRepository.save(ticket);
        orderCommandGateway.send(ticket.toAcceptOrder());
    }

    private void sendOrderRejectCommand(Ticket ticket) {
        ticket.reject();
        this.orderCommandGateway.send(ticket.toOrderRejected());
    }

}
