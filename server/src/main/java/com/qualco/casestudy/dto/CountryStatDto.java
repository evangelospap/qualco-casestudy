package com.qualco.casestudy.dto;

/**
 * Data Transfer Object representing statistical information for a country.
 *
 * @param name type String       the name of the country
 * @param countryCode3 type String the 3-letter country code (ISO 3166-1 alpha-3)
 * @param year type Integer       the year of the statistics
 * @param population type Integer the population of the country in the given year
 * @param gdp type Double         the Gross Domestic Product of the country in the given year
 */
public record CountryStatDto(
    String name,
    String countryCode3,
    Integer year,
    Integer population,
    Double gdp
) {}