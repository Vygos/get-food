package com.getfood.order.infrastructure.mapper;

import com.getfood.order.application.dto.input.OrderInputDTO;
import com.getfood.order.core.domain.model.Order;
import com.getfood.order.infrastructure.persistence.entity.OrderEntity;
import com.vygos.core.message.command.CreateTicketCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderInputDTO order);

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

    CreateTicketCommand toTicket(Order order);
}
