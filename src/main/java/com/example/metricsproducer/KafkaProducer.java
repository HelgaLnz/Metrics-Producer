package com.example.metricsproducer;

import com.example.metricsproducer.dto.MetricsDto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

  @Value("${spring.kafka.producer.topic}")
  private String TOPIC;

  private final KafkaTemplate<String, MetricsDto> kafkaTemplate;
  private final MetricsService metricsService;

  public void sendMetrics() {
    MetricsDto metrics = metricsService.getMetrics();
    JsonNode node = metrics.getMeasurements();
    log.info(String.format("Producing metrics -> %s", metrics));
    kafkaTemplate.send(TOPIC, metrics);
  }
}
