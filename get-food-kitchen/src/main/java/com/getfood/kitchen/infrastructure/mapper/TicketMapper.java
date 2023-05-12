package com.getfood.kitchen.infrastructure.mapper;

import com.getfood.kitchen.core.domain.model.Ticket;
import com.getfood.kitchen.infrastructure.persistence.entity.TicketEntity;
import com.vygos.core.message.command.CreateTicketCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mappings({
        @Mapping(source = "order.id", target = "orderId"),
        @Mapping(source = "order.total", target = "total"),
        @Mapping(source = "order.restaurant.restaurantId", target = "restaurant.id"),
        @Mapping(source = "order.preparationInstructions", target = "preparationInstructions"),
        @Mapping(source = "order.items", target = "items"),
    })
    Ticket toDomain(CreateTicketCommand ticketCommand);
    Ticket toDomain(TicketEntity ticketentity);

    TicketEntity toEntity(Ticket ticket);

}
