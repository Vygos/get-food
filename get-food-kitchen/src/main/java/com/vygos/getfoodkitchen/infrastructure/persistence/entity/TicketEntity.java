package com.vygos.getfoodkitchen.infrastructure.persistence.entity;

import com.vygos.core.enums.AbstractEnumConverter;
import com.vygos.getfoodkitchen.core.domain.enums.TicketStatus;
import com.vygos.getfoodkitchen.core.domain.model.Restaurant;
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

    @Convert(converter = AbstractEnumConverter.class)
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
