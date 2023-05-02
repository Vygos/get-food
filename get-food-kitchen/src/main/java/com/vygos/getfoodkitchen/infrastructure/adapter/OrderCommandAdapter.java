package com.vygos.getfoodkitchen.infrastructure.adapter;

import com.vygos.core.message.command.OrderAcceptCommand;
import com.vygos.core.message.command.OrderRejectCommand;
import com.vygos.getfoodkitchen.application.config.kafka.KafkaTopics;
import com.vygos.getfoodkitchen.core.ports.outgoing.OrderCommandGateway;
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
    public void send(OrderAcceptCommand orderAcceptedCommand) {
        this.template.send(KafkaTopics.ORDER_ACCEPT_TOPIC, orderAcceptedCommand);
    }
}
