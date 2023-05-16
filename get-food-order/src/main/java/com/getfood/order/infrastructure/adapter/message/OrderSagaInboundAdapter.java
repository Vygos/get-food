package com.getfood.order.infrastructure.adapter.message;

import com.getfood.order.core.domain.enums.OrderStatus;
import com.getfood.order.core.domain.model.Order;
import com.getfood.order.core.ports.ingoing.OrderSagaInbound;
import com.getfood.order.core.service.OrderService;
import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;
import com.vygos.core.message.command.OrderSagaTopics;
import com.vygos.core.message.command.VerifyCourierCommandReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.vygos.core.message.command.OrderSagaTopics.*;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderSagaInboundAdapter implements OrderSagaInbound {
    private final OrderService orderService;

    @KafkaListener(topics = CREATE_TICKET_REPLY_TOPIC, groupId = "get-food-order-ticket-create-reply")
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

    @KafkaListener(topics = CREATE_ORDER_REJECT_TOPIC, groupId = "get-food-order-order-reject")
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

    @KafkaListener(topics = VERIFY_COURIER_REPLY_TOPIC, groupId = "get-food-order-courier-verify-reply")
    public void verifyCourierReply(VerifyCourierCommandReply verifyCourierCommandReply) {
        log.info("[RejectOrder] Receiving event of orderId: {}, ticketId: {}",
            verifyCourierCommandReply.getOrderId(),
            verifyCourierCommandReply.getTicketId());

        Order order = Order.builder()
            .id(verifyCourierCommandReply.getOrderId())
            .status(OrderStatus.READY_TO_ACCEPTANCE)
            .build();

        this.orderService.updateOrderStatusToReadyToAcceptance(order);
    }
}
