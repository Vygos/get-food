package com.getfood.order.core.domain.model;

import com.vygos.core.message.command.VerifyCourierCommand;
import com.getfood.order.core.domain.enums.OrderStatus;
import com.getfood.order.core.domain.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private Address source;
    private Address destination;
    private List<OrderItems> items = new ArrayList<>();

    public void changeToPending() {
        this.status = OrderStatus.PENDING;
    }

    public void calculateTotal() {
        this.total = this.items.stream()
            .map(OrderItems::calculatePrice)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    }

    public void prepareCreate() {
        changeToPending();
        calculateTotal();
        var now = ZonedDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public VerifyCourierCommand toVerifyCommand() {
        return VerifyCourierCommand.builder()
            .orderId(id)
            .status(status.getValue())
            .build();
    }


}
