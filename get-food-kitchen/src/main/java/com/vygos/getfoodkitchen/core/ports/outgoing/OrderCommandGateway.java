package com.vygos.getfoodkitchen.core.ports.outgoing;

import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;

public interface OrderCommandGateway {

    void send(OrderRejectCommand orderRejectCommand);
    void send(CreateTicketCommandReply createTicketCommandReply);
}
