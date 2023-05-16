package com.getfood.kitchen.core.domain.model;

import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;
import com.getfood.kitchen.core.domain.enums.TicketStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    private UUID id;
    private UUID orderId;
    private Restaurant restaurant;
    private TicketStatus status;
    private BigDecimal total;
    private String preparationInstructions;
    private List<Item> items = new ArrayList<>();

    public OrderRejectCommand toOrderRejected() {
        return OrderRejectCommand.builder()
            .orderId(orderId)
            .status(status.getValue())
            .build();
    }

    public void changeToRejected() {
        this.status = TicketStatus.REJECTED;
    }

    public void changeToCourierVerifyPending() {
        this.status = TicketStatus.COURIER_VERIFY_PENDING;
    }

    public CreateTicketCommandReply toAcceptOrder() {
        return CreateTicketCommandReply.builder()
            .ticketId(id)
            .orderId(orderId)
            .status(status.getValue())
            .build();
    }

}
