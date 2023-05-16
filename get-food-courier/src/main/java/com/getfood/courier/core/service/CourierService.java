package com.getfood.courier.core.service;

import com.getfood.courier.core.domain.CourierUser;
import com.getfood.courier.core.ports.outgoing.CourierUserGateway;
import com.getfood.courier.core.ports.outgoing.OrderCommandGateway;
import com.vygos.core.message.command.VerifyCourierCommand;
import com.vygos.core.message.command.VerifyCourierCommandReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourierService {

    private final CourierUserGateway courierUserGateway;
    private final OrderCommandGateway orderCommandGateway;

    public void verifyCourierAvailable(VerifyCourierCommand command) {
        List<CourierUser> online = this.courierUserGateway.findByOnline();

        if (online.isEmpty()) {
            log.info("Doest have courier available at the moment");
        }

        VerifyCourierCommandReply reply = VerifyCourierCommandReply.builder()
            .orderId(command.getOrderId())
            .ticketId(command.getTicketId())
            .build();

        this.orderCommandGateway.send(reply);
    }
}
