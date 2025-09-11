package com.qualco.casestudy.dto;

public interface CountryTopStatProjection {
    Integer getCountryId();
    String getCountryName();
    String getCountryCode2();
    String getCountryCode3();

    Integer getYear();
    Double getGdp();
    Integer getPopulation();
}