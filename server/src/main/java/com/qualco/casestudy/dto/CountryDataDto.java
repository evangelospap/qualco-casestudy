package com.qualco.casestudy.dto;

// CountryDataDTO.java
public record CountryDataDto(
    String continent,
    String region,
    String country,
    Integer year,
    Long population,
    Long gdp
) {}
