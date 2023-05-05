package com.vygos.getfoodorder.core.ports.outgoing;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.core.message.command.VerifyCourierCommand;

public interface OrderSagaGateway {

    void send(CreateTicketCommand command);
    void send(VerifyCourierCommand command);

}
