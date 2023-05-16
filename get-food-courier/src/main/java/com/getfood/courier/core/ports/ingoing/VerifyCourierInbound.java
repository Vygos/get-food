package com.getfood.courier.core.ports.ingoing;

import com.vygos.core.message.command.VerifyCourierCommand;

public interface VerifyCourierInbound {

    void verifyCourier(VerifyCourierCommand command);
}
