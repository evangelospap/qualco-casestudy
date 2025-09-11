package com.qualco.casestudy.dto;

public interface CountryDataProjection {
    String getContinent();
    String getRegion();
    String getCountry();
    Integer getYear();
    Integer getPopulation();
    Double getGdp();
}