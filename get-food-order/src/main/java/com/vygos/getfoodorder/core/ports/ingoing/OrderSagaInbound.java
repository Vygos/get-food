package com.vygos.getfoodorder.core.ports.ingoing;

import com.vygos.core.message.command.CreateTicketCommandReply;

public interface OrderSagaInbound {

    void createTicketReply(CreateTicketCommandReply createTicketCommandReply);
}
