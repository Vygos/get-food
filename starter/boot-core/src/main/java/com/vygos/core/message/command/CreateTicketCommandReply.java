package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateTicketCommandReply {
    private UUID orderId;
    private UUID ticketId;
    private String status;
}
