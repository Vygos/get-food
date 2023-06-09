package com.getfood.kitchen.infrastructure.persistence.entity;

import com.getfood.kitchen.core.domain.enums.TicketStatus;
import com.getfood.kitchen.infrastructure.persistence.converter.TicketStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TICKET")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "TICKET_ID")
    private UUID id;

    @Column(name = "ORDER_ID")
    private UUID orderId;

    @Convert(converter = TicketStatusConverter.class)
    @Column(name = "STATUS")
    private TicketStatus status;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @Column(name = "PREPARATION_INSTRUCTIONS")
    private String preparationInstructions;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private RestaurantEntity restaurant;
}
