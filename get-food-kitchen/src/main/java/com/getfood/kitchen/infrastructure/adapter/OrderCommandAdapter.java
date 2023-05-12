package com.getfood.kitchen.infrastructure.adapter;

import com.getfood.kitchen.application.config.kafka.KafkaTopics;
import com.getfood.kitchen.core.ports.outgoing.OrderCommandGateway;
import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderCommandAdapter implements OrderCommandGateway {

    private final KafkaTemplate<String, Object> template;

    @Override
    public void send(OrderRejectCommand orderRejectCommand) {
        this.template.send(KafkaTopics.ORDER_REJECT_TOPIC, orderRejectCommand);
    }

    @Override
    public void send(CreateTicketCommandReply createTicketCommandReply) {
        this.template.send(KafkaTopics.CREATE_TICKET_REPLY_TOPIC, createTicketCommandReply);
    }
}
