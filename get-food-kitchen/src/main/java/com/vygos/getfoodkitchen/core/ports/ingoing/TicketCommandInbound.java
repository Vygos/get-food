package com.vygos.getfoodkitchen.core.ports.ingoing;

import com.vygos.core.message.command.CreateTicketCommand;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface TicketCommandInbound {

    void createTicket(CreateTicketCommand ticketCommand);

}
