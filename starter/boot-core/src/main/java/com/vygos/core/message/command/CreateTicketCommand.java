package com.vygos.core.message.command;

import com.vygos.core.model.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CreateTicketCommand {

    private Order order;
}
