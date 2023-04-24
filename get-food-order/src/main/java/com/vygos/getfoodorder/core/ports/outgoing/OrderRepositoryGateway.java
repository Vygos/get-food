package com.vygos.getfoodorder.core.ports.outgoing;

import com.vygos.getfoodorder.core.domain.model.Order;

public interface OrderRepositoryGateway {

    Order save(Order order);
}
