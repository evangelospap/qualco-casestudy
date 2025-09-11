package com.qualco.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.qualco.casestudy.dto.CountryTopStatProjection;
import com.qualco.casestudy.model.CountryStat;
import com.qualco.casestudy.model.CountryStatId;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId>,
        JpaSpecificationExecutor<CountryStat> { 
    @Query(value = """
            SELECT c.country_id AS countryId,
                   c.name AS countryName,
                   c.country_code2 AS countryCode2,
                   c.country_code3 AS countryCode3,
                   cs.year AS year,
                   cs.gdp AS gdp,
                   cs.population AS population
            FROM countries c
            JOIN (
                SELECT *
                FROM (
                    SELECT cs.*,
                           DENSE_RANK() OVER (
                               PARTITION BY cs.country_id
                               ORDER BY cs.gdp / cs.population DESC
                           ) AS rank
                    FROM country_stats cs
                ) ranked
                WHERE rank = 1
            ) cs ON cs.country_id = c.country_id
            """, nativeQuery = true)
    List<CountryTopStatProjection> findCountriesWithTopGdpPerCapitaStats();
}

