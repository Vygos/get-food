package com.getfood.courier.core.ports.outgoing;

import com.vygos.core.message.command.VerifyCourierCommand;
import com.vygos.core.message.command.VerifyCourierCommandReply;

public interface OrderCommandGateway {

    void send(VerifyCourierCommandReply command);
}
