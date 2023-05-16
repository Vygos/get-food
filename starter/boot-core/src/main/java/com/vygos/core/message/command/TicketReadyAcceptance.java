package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketReadyAcceptance {
    private UUID orderId;

}
