package com.getfood.kitchen.infrastructure.adapter;

import com.getfood.kitchen.core.ports.outgoing.TicketEventGateway;
import com.vygos.core.message.command.TicketAcceptedEvent;
import com.vygos.core.message.command.TicketEventTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TicketEventGatewayAdapter implements TicketEventGateway {

    private final KafkaTemplate<String, Object> template;

    @Override
    public void send(TicketAcceptedEvent event) {
        this.template.send(TicketEventTopics.TICKET_ACCEPTED_TOPIC, event);
    }
}
