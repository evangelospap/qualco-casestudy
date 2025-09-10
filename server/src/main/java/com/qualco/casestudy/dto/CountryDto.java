package com.qualco.casestudy.dto;

import java.math.BigDecimal;

public record CountryDto(
    Integer id,
    String name,
    BigDecimal area,
    String countryCode2
) {}
