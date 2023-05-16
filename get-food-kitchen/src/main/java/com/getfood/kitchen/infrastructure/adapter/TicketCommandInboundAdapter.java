package com.getfood.kitchen.infrastructure.adapter;


import com.getfood.kitchen.core.domain.enums.TicketStatus;
import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.core.service.KitchenService;
import com.getfood.kitchen.infrastructure.mapper.TicketMapper;
import com.vygos.core.message.command.CreateTicketCommand;
import com.getfood.kitchen.core.ports.ingoing.TicketCommandInbound;
import com.vygos.core.message.command.TicketReadyAcceptance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import static com.vygos.core.message.command.OrderSagaTopics.CREATE_TICKET_TOPIC;
import static com.vygos.core.message.command.OrderSagaTopics.TICKET_READY_ACCEPTANCE_TOPIC;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TicketCommandInboundAdapter implements TicketCommandInbound {

    private final KitchenService service;
    private final TicketMapper mapper;

    @Override
    @KafkaListener(topics = CREATE_TICKET_TOPIC, groupId = "get-food-kitchen-ticket-create")
    public void createTicket(CreateTicketCommand ticketCommand) {
        log.info("[TicketCommandAdapter] receiving event of ticket: {}", ticketCommand.getOrder().getId());
        this.service.saveTicket(mapper.toDomain(ticketCommand));
    }

    @Override
    @KafkaListener(topics = TICKET_READY_ACCEPTANCE_TOPIC, groupId = "get-food-kitchen-ticket-create")
    public void readyToAcceptance(TicketReadyAcceptance ticketCommand) {
        log.info("[TicketCommandAdapter] receiving command to ready for acceptance, orderId: {}", ticketCommand.getOrderId());

        Ticket ticket = Ticket.builder()
            .orderId(ticketCommand.getOrderId())
            .status(TicketStatus.READY_TO_ACCEPTANCE)
            .build();

        this.service.updateReadyToAcceptance(ticket);
    }
}
