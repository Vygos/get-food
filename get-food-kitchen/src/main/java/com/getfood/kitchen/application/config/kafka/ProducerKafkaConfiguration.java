package com.getfood.kitchen.application.config.kafka;

import com.vygos.kafka.KafkaProducerConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerKafkaConfiguration extends KafkaProducerConfig<Object> {
}
