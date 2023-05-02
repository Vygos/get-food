package com.vygos.core.message.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class OrderAcceptCommand {
    private UUID orderId;
    private UUID ticketId;
    private String status;
}
