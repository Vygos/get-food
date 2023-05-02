package com.vygos.getfoodkitchen.infrastructure.mapper;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.getfoodkitchen.core.domain.model.Ticket;
import com.vygos.getfoodkitchen.infrastructure.persistence.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mappings({
        @Mapping(source = "order.id", target = "orderId"),
        @Mapping(source = "order.status", target = "status"),
        @Mapping(source = "order.total", target = "total"),
        @Mapping(source = "order.restaurant.restaurantId", target = "restaurant.id"),
        @Mapping(source = "order.preparationInstructions", target = "preparationInstructions"),
        @Mapping(source = "order.items", target = "items"),
    })
    Ticket toDomain(CreateTicketCommand ticketCommand);

    TicketEntity toEntity(Ticket ticket);

}
