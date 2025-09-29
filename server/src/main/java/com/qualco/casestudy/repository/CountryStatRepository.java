package com.qualco.casestudy.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.qualco.casestudy.dto.CountryDataProjection;
import com.qualco.casestudy.dto.CountryTopStatProjection;
import com.qualco.casestudy.model.CountryStat;
import com.qualco.casestudy.model.CountryStatId;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId>
    // , JpaSpecificationExecutor<CountryStat> 
    { 
        
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


    @Query(value = """
        SELECT con.name AS continent,
               rgn.name AS region,
               ctr.name AS country,
               cs.year AS year,
               cs.population AS population,
               cs.gdp AS gdp
        FROM country_stats cs
        JOIN countries ctr ON cs.country_id = ctr.country_id
        JOIN regions rgn ON ctr.region_id = rgn.region_id
        JOIN continents con ON rgn.continent_id = con.continent_id
        WHERE (:regionId IS NULL OR rgn.region_id = :regionId)
          AND (:yearFrom IS NULL OR cs.year >= :yearFrom)
          AND (:yearTo IS NULL OR cs.year <= :yearTo)
        """,
        countQuery = """
        SELECT COUNT(*)
        FROM country_stats cs
        JOIN countries ctr ON cs.country_id = ctr.country_id
        JOIN regions rgn ON ctr.region_id = rgn.region_id
        JOIN continents con ON rgn.continent_id = con.continent_id
        WHERE (:regionId IS NULL OR rgn.region_id = :regionId)
          AND (:yearFrom IS NULL OR cs.year >= :yearFrom)
          AND (:yearTo IS NULL OR cs.year <= :yearTo)
        """,
        nativeQuery = true)
    Page<CountryDataProjection> findCountryDataPaginated(Integer regionId, Integer yearFrom, Integer yearTo, Pageable pageable);

}

