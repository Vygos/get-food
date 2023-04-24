package com.vygos.getfoodorder.core.service;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.core.ports.outgoing.OrderRepositoryGateway;
import com.vygos.getfoodorder.core.ports.outgoing.OrderSagaGateway;
import com.vygos.getfoodorder.infrastructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepositoryGateway orderRepositoryGateway;
    private final OrderMapper orderMapper;
    private final OrderSagaGateway orderSagaGateway;

    @Transactional
    public Order save(Order order) {
        order.prepareCreate();
        Order orderPersisted = this.orderRepositoryGateway.save(order);
        CreateTicketCommand createTicketCommand = this.orderMapper.toTicket(orderPersisted);
        this.orderSagaGateway.send(createTicketCommand);
        return orderPersisted;
    }

}
