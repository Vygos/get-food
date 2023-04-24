package com.vygos.kafka;

import com.vygos.kafka.config.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableConfigurationProperties(value = KafkaProperties.class)
@RequiredArgsConstructor
@AutoConfiguration
public class KafkaTopic {

  private final KafkaProperties config;

  @Bean
  public KafkaAdmin.NewTopics topics() {
    var kafkaProps = config.getKafka();
    var kafkaTopics = kafkaProps.getKafkaTopics().entrySet();
    List<NewTopic> topics = new ArrayList<>();


    for(Map.Entry<String, String> entry: kafkaTopics) {
      topics.add(
          TopicBuilder
              .name(entry.getValue())
              .partitions(kafkaProps.getPartitions())
              .replicas(kafkaProps.getReplicas())
              .build()
      );
    }

    return new KafkaAdmin.NewTopics(
        topics.toArray(new NewTopic[kafkaTopics.size()])
    );
  }

}
