package com.example.metricsproducer;

import com.example.metricsproducer.dto.MetricsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Класс для отправки метрик в Kafka
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

  /* Наименование топика в Kafka */
  @Value("${spring.kafka.producer.topic}")
  private String TOPIC;

  private final KafkaTemplate<String, MetricsDto> kafkaTemplate;

  /* Сервис для получения метрик */
  private final MetricsService metricsService;

  /* Метод для отправки метрик в Kafka */
  public void sendMetrics() {
    MetricsDto metrics = metricsService.getMetrics();
    log.info(String.format("Producing metrics -> %s", metrics));
    kafkaTemplate.send(TOPIC, metrics);
  }
}
