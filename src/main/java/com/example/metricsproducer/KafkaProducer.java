package com.example.metricsproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

  @Value("${spring.kafka.producer.topic}")
  private String TOPIC;

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final RestTemplate restTemplate;

  public void sendMetrics() {
    String metrics = restTemplate.getForObject("http://localhost:8081/actuator/metrics", String.class);
    log.info(String.format("Producing metrics -> %s", metrics));
    kafkaTemplate.send(TOPIC, metrics);
  }
}
