package com.vygos.getfoodorder.infrastructure.adapter.message;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.core.message.command.VerifyCourierCommand;
import com.vygos.getfoodorder.core.ports.outgoing.OrderSagaGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.vygos.getfoodorder.application.config.kafka.KafkaTopics.CREATE_TICKET_TOPIC;
import static com.vygos.getfoodorder.application.config.kafka.KafkaTopics.VERIFY_COURIER_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderSagaOutboundAdapter implements OrderSagaGateway {

    private final KafkaTemplate<String, Object> template;

    public void send(CreateTicketCommand command) {
        log.info("[CreateTicketCommand] Dispatch event to create ticket orderId: {}", command.getOrder().getId());
        this.template.send(CREATE_TICKET_TOPIC, command);
    }

    @Override
    public void send(VerifyCourierCommand command) {
        log.info("[VerifyCourierCommand] Dispatch event to verify courier orderId: {}", command.getOrderId());
        this.template.send(VERIFY_COURIER_TOPIC, command);
    }
}
