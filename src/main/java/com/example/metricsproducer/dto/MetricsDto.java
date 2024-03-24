package com.example.metricsproducer.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO класса метрик
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetricsDto {

  /* Наименование метрики */
  private String name;

  /* Описание метрики */
  private String description;

  /* Измерения */
  private JsonNode measurements;

  /* Дата и время метрики */
  private Long createdAt;
}