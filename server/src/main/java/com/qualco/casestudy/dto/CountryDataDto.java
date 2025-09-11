package com.qualco.casestudy.dto;

// CountryDataDTO.java
public record CountryDataDto(
    String continent,
    String region,
    String country,
    Integer year,
    Integer population,
    Double gdp
) {}
