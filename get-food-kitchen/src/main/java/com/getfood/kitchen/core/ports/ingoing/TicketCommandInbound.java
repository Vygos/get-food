package com.getfood.kitchen.core.ports.ingoing;

import com.vygos.core.message.command.CreateTicketCommand;
import com.vygos.core.message.command.TicketReadyAcceptance;

public interface TicketCommandInbound {

    void createTicket(CreateTicketCommand command);
    void readyToAcceptance(TicketReadyAcceptance command);

}
