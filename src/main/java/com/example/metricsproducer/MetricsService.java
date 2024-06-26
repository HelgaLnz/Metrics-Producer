package com.example.metricsproducer;

import com.example.metricsproducer.dto.MetricsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Сервис метрик для получения метрик из Actuator
 */
@Service
@RequiredArgsConstructor
public class MetricsService {

  /* URL метрики spring.kafka.template */
  private static final String URL_METRICS = "http://localhost:8081/actuator/metrics/spring.kafka.template";

  private final RestTemplate restTemplate;

  /* Получить метрики */
  public MetricsDto getMetrics() {
    Optional<MetricsDto> metrics = Optional.ofNullable(restTemplate.getForObject(URL_METRICS, MetricsDto.class));
    metrics.ifPresent(mt -> mt.setCreatedAt(System.currentTimeMillis()));
    return metrics.orElseThrow();
  }
}
