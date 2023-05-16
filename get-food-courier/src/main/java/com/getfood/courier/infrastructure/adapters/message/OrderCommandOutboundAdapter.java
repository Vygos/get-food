package com.getfood.courier.infrastructure.adapters.message;

import com.getfood.courier.core.ports.outgoing.OrderCommandGateway;
import com.vygos.core.message.command.OrderSagaTopics;
import com.vygos.core.message.command.VerifyCourierCommandReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.vygos.core.message.command.OrderSagaTopics.VERIFY_COURIER_REPLY_TOPIC;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCommandOutboundAdapter implements OrderCommandGateway {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(VerifyCourierCommandReply command) {
        log.info("Sending event to reply courier available, orderId: {}, ticketId: {}",
            command.getOrderId(), command.getTicketId());
        this.kafkaTemplate.send(VERIFY_COURIER_REPLY_TOPIC, command);
    }
}
