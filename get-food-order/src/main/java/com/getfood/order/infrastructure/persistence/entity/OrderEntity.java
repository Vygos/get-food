package com.getfood.order.infrastructure.persistence.entity;

import com.getfood.order.core.domain.enums.OrderStatus;
import com.getfood.order.core.domain.enums.PaymentMethod;
import com.getfood.order.infrastructure.persistence.converter.OrderStatusConverter;
import com.getfood.order.infrastructure.persistence.converter.PaymentMethodConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ORDER_ID")
    private UUID id;

    @Column(name = "USER_ID")
    private UUID userId;

    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "STATUS")
    private OrderStatus status;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private ZonedDateTime updatedAt;

    @Column(name = "PREPARATION_INSTRUCTIONS")
    private String preparationInstructions;

    @Convert(converter = PaymentMethodConverter.class)
    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "RESTAURANT_ID")
    private RestaurantEntity restaurant;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_SOURCE_ID")
    private AddressEntity source;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_DESTINATION_ID")
    private AddressEntity destination;

    @OneToMany(mappedBy = "order", cascade = ALL, orphanRemoval = true)
    private List<OrderItemsEntity> items = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.items.forEach(oi -> oi.setOrder(this));
    }

}
