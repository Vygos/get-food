package com.vygos.getfoodorder.core.ports.outgoing;

import com.vygos.core.message.command.CreateTicketCommand;

public interface OrderSagaGateway {

    void send(CreateTicketCommand ticketCommand);

}
