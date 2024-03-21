package com.example.metricsproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producer")
@RequiredArgsConstructor
public class MetricsController {

  private final KafkaProducer producer;

  @PostMapping("/metrics")
  public ResponseEntity<String> sendMetrics() {
    producer.sendMetrics();
    return new ResponseEntity<>("Metrics have been sent", HttpStatus.OK);
  }
}
