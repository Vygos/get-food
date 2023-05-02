package com.vygos.core.message.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderRejectCommand {
    private UUID orderId;
    private String status;
}
