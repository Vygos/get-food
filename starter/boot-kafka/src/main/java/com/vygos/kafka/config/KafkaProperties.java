package com.vygos.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Getter
@ConfigurationProperties("vygos")
public class KafkaProperties {

  private Kafka kafka = new Kafka();

  @Getter
  @Setter
  public static class Kafka {
    private Integer replicas;
    private Integer partitions;
    private Map<String, String> kafkaTopics = new HashMap<>();
  }
}
