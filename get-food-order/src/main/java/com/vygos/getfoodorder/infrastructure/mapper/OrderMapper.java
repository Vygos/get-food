package com.vygos.getfoodorder.infrastructure.mapper;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodorder.application.web.dto.input.OrderInputDTO;
import com.vygos.getfoodorder.core.domain.model.Order;
import com.vygos.getfoodorder.infrastructure.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderInputDTO order);

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

    CreateTicketCommand toTicket(Order order);
}
