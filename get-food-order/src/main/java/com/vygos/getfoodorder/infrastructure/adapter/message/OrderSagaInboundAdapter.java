package com.vygos.getfoodorder.infrastructure.adapter.message;

import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;
import com.vygos.getfoodorder.application.config.kafka.KafkaTopics;
import com.vygos.getfoodorder.core.domain.enums.OrderStatus;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.core.ports.ingoing.OrderSagaInbound;
import com.vygos.getfoodorder.core.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderSagaInboundAdapter implements OrderSagaInbound {
    private final OrderService orderService;

    @KafkaListener(topics = KafkaTopics.CREATE_TICKET_REPLY_TOPIC, groupId = "get-food-order-ticket-create-reply")
    @Override
    public void createTicketReply(CreateTicketCommandReply createTicketCommandReply) {
        log.info("[CreateTicketCommandReply] Receiving event of orderId: {}, status: {}, ticketId: {}",
            createTicketCommandReply.getOrderId(),
            createTicketCommandReply.getStatus(),
            createTicketCommandReply.getTicketId());

        var order = Order.builder()
            .id(createTicketCommandReply.getOrderId())
            .status(OrderStatus.COURIER_VERIFY_PENDING)
            .build();

        this.orderService.updateOrderStatusToVerifyCourier(order);
    }

    @KafkaListener(topics = KafkaTopics.CREATE_ORDER_REJECT_TOPIC, groupId = "get-food-order-order-reject")
    @Override
    public void rejectOrder(OrderRejectCommand orderRejectCommand) {
        log.info("[RejectOrder] Receiving event of orderId: {}, status: {}",
            orderRejectCommand.getOrderId(),
            orderRejectCommand.getStatus());

        var order = Order.builder()
            .id(orderRejectCommand.getOrderId())
            .status(OrderStatus.getOrderStatus(orderRejectCommand.getStatus()))
            .build();

        this.orderService.updateOrderStatusToRejected(order);
    }
}
