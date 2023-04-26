package com.vygos.getfoodorder.application.config.kafka;

import com.vygos.core.message.command.CreateTicketCommand;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfiguration extends com.vygos.kafka.KafkaProducerConfig<Object> {
}
