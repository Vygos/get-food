package com.vygos.getfoodorder.core.service;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.core.ports.outgoing.OrderRepositoryGateway;
import com.vygos.getfoodorder.core.ports.outgoing.OrderSagaGateway;
import com.vygos.getfoodorder.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepositoryGateway orderRepositoryGateway;
    private final OrderMapper orderMapper;
    private final OrderSagaGateway orderSagaGateway;

    public Order saveAndDispatchEvent(Order order) {
        Order orderPersisted = this.save(order);
        CreateTicketCommand createTicketCommand = this.orderMapper.toTicket(orderPersisted);
        this.orderSagaGateway.send(createTicketCommand);
        return orderPersisted;
    }
    @Transactional
    public Order save(Order order) {
        order.prepareCreate();
        return this.orderRepositoryGateway.save(order);
    }

    @Transactional
    public Order updateStatus(Order order) {
        var orderOptional = this.orderRepositoryGateway.findById(order.getId());

        if (orderOptional.isEmpty()) {
            return order;
        }

        Order orderPersisted = orderOptional.get();
        orderPersisted.setStatus(order.getStatus());
        return this.orderRepositoryGateway.update(orderPersisted);
    }

    public void updateOrderStatusToVerifyCourier(Order order) {
        Order orderUpdated = this.updateStatus(order);
        this.orderSagaGateway.send(orderUpdated.toVerifyCommand());
    }

    public void updateOrderStatusToRejected(Order order) {
        this.updateStatus(order);
    }
}
