package com.getfood.kitchen.core.ports.ingoing;

import com.vygos.core.message.command.CreateTicketCommand;

public interface TicketCommandInbound {

    void createTicket(CreateTicketCommand ticketCommand);

}
