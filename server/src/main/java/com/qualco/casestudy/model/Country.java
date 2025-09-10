package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false , unique = true)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "area", precision = 10, scale = 2, nullable = false)
    private BigDecimal area;

    @Column(name = "national_day")
    private LocalDate nationalDay;

    @Column(name = "country_code2", length = 2, nullable = false, unique = true)
    private String countryCode2;

    @Column(name = "country_code3", length = 3, nullable = false, unique = true)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<CountryStat> stats;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<CountryLanguage> languages;
}
