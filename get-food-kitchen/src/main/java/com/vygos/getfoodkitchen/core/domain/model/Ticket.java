package com.vygos.getfoodkitchen.core.domain.model;

import com.vygos.core.message.command.OrderAcceptCommand;
import com.vygos.core.message.command.OrderRejectCommand;
import com.vygos.getfoodkitchen.core.domain.enums.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Ticket {

    private UUID id;
    private UUID orderId;
    private Restaurant restaurant;
    private TicketStatus status;
    private BigDecimal total;
    private String preparationInstructions;
    private Boolean active;
    private List<Item> items = new ArrayList<>();

    public OrderRejectCommand toOrderRejected() {
        return OrderRejectCommand.builder()
            .orderId(orderId)
            .status(status.getValue())
            .build();
    }

    public void reject() {
        this.status = TicketStatus.REJECTED;
    }

    public void pending() {
        this.status = TicketStatus.PENDING;
    }
    public OrderAcceptCommand toAcceptOrder() {
        return OrderAcceptCommand.builder()
            .ticketId(id)
            .orderId(orderId)
            .status(status.getValue())
            .build();
    }

}
