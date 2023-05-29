package com.getfood.order.infrastructure.adapter.message;

import com.getfood.order.core.domain.enums.OrderStatus;
import com.getfood.order.core.domain.model.Order;
import com.getfood.order.core.service.OrderService;
import com.vygos.core.message.command.TicketAcceptedEvent;
import com.vygos.core.message.command.TicketEventTopics;
import com.vygos.kafka.KafkaTopic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@RequiredArgsConstructor
@Configuration
public class OrderTicketEventInbound {

    private final OrderService orderService;

    @KafkaListener(topics = {TicketEventTopics.TICKET_ACCEPTED_TOPIC})
    public void acceptedTicket(TicketAcceptedEvent acceptedEvent) {
        log.info("Receiving event of accepted ticket, orderId : {}", acceptedEvent.getOrderId());

        Order order = Order.builder()
            .id(acceptedEvent.getOrderId())
            .status(OrderStatus.getOrderStatus(acceptedEvent.getStatus()))
            .build();

        this.orderService.updateStatus(order);
    }
}
