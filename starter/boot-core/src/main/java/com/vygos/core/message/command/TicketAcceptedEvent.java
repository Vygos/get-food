package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TicketAcceptedEvent {
    private UUID id;
    private UUID orderId;
    private String status;
}
