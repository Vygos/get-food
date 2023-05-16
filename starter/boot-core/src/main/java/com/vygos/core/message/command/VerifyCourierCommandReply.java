package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifyCourierCommandReply {
    private UUID orderId;
    private UUID ticketId;
}
