package com.vygos.getfoodorder.core.domain.model;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.core.domain.enums.OrderStatus;
import com.vygos.getfoodorder.core.domain.enums.PaymentMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class Order {

    private UUID id;
    private UUID userId;
    private OrderStatus status;
    private Integer version;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String preparationInstructions;
    private PaymentMethod paymentMethod;
    private BigDecimal total;
    private Restaurant restaurant;
    private Address address;
    private List<OrderItems> items = new ArrayList<>();

    public void changeToPendingState() {
        this.status = OrderStatus.PENDING;
    }

    public void calculateTotal() {
        this.total = this.items.stream()
            .map(OrderItems::calculatePrice)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    }

    public void prepareCreate() {
        changeToPendingState();
        calculateTotal();
        var now = ZonedDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }


}