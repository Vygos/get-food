package com.vygos.getfoodorder.infrastructure.adapter.message;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.core.ports.outgoing.OrderSagaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.vygos.getfoodorder.application.config.kafka.KafkaTopics.CREATE_TICKET_TOPIC;

@Component
@RequiredArgsConstructor
public class TicketCommandAdapter implements OrderSagaGateway {

    private final KafkaTemplate<String, CreateTicketCommand> template;

    public void send(CreateTicketCommand command) {
        this.template.send(CREATE_TICKET_TOPIC, command);
    }
}
