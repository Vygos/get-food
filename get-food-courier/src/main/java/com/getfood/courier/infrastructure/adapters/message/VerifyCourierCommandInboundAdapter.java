package com.getfood.courier.infrastructure.adapters.message;

import com.getfood.courier.core.ports.ingoing.VerifyCourierInbound;
import com.getfood.courier.core.service.CourierService;
import com.vygos.core.message.command.OrderSagaTopics;
import com.vygos.core.message.command.VerifyCourierCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import static com.vygos.core.message.command.OrderSagaTopics.VERIFY_COURIER_TOPIC;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class VerifyCourierCommandInboundAdapter implements VerifyCourierInbound {

    private final CourierService courierService;

    @KafkaListener(topics = VERIFY_COURIER_TOPIC, groupId = "get-food-courier-courier-verify-courier")
    @Override
    public void verifyCourier(VerifyCourierCommand command) {
        log.info("Receiving event to verify courier available, orderId: {}, ticketId: {}",
            command.getOrderId(), command.getTicketId());

        this.courierService.verifyCourierAvailable(command);
    }
}
