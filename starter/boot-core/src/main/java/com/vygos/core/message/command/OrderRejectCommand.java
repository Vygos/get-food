package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRejectCommand {
    private UUID orderId;
    private String status;
}
