package com.vygos.getfoodorder.core.ports.ingoing;

import com.vygos.core.message.command.CreateTicketCommandReply;
import com.vygos.core.message.command.OrderRejectCommand;

public interface OrderSagaInbound {

    void createTicketReply(CreateTicketCommandReply createTicketCommandReply);
    void rejectOrder(OrderRejectCommand orderRejectCommand);
}
