package com.vygos.core.message.command;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class VerifyCourierCommand {

    private UUID orderId;
    private UUID ticketId;
    private String status;
}
