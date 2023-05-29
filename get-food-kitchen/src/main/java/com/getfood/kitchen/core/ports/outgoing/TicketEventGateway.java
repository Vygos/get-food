package com.getfood.kitchen.core.ports.outgoing;

import com.vygos.core.message.command.TicketAcceptedEvent;

public interface TicketEventGateway {

    void send(TicketAcceptedEvent event);
}
