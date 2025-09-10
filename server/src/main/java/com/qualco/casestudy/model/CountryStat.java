package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStat {
    @EmbeddedId
    private CountryStatId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("countryId") // links countryId in CountryStatId to Country
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(nullable = false)
    private Integer population;

    @Column(nullable = false)
    private Double gdp;

    public Integer getYear() {
        return id != null ? id.getYear() : null;
    }

    public void setYear(Integer year) {
        if (id == null) {
            id = new CountryStatId();
        }
        id.setYear(year);
    }

    public CountryStat(Country country, Integer year, Integer population, Double gdp) {
        this.id = new CountryStatId(country.getId(), year);
        this.country = country;
        this.population = population;
        this.gdp = gdp;
    }
}
