package com.vygos.getfoodorder.infrastructure.mapper;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.application.dto.input.OrderInputDTO;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.infrastructure.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderInputDTO order);

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

    CreateTicketCommand toTicket(Order order);
}
