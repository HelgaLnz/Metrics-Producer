package com.example.metricsproducer.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetricsDto {

  private String name;

  private String description;

  private JsonNode measurements;

  private Long createdAt;
}