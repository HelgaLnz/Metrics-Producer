package com.example.metricsproducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MetricsConfig {

  @Bean
  public RestTemplate template() {
    return new RestTemplate();
  }
}
