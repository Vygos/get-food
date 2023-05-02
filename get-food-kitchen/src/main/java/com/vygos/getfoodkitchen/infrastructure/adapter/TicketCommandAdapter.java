package com.vygos.getfoodkitchen.infrastructure.adapter;


import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodkitchen.application.config.kafka.KafkaTopics;
import com.vygos.getfoodkitchen.core.ports.ingoing.TicketCommandInbound;
import com.vygos.getfoodkitchen.core.service.KitchenService;
import com.vygos.getfoodkitchen.infrastructure.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
@Configuration
public class TicketCommandAdapter implements TicketCommandInbound {

    private final KitchenService service;
    private final TicketMapper mapper;

    @Override
    @KafkaListener(topics = KafkaTopics.CREATE_TICKET_TOPIC, groupId = "get-food-kitchen-ticket-create")
    public void createTicket(CreateTicketCommand ticketCommand) {
        this.service.saveTicket(mapper.toDomain(ticketCommand));
    }
}
