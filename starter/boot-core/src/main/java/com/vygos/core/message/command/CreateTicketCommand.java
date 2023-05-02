package com.vygos.core.message.command;

import com.vygos.core.model.Order;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CreateTicketCommand {

    private Order order;
}
