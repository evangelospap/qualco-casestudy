package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("countryId") // links countryId in CountryLanguageId to Country
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id") // links languageId in CountryLanguageId to Language
    private Language language;

    @Column(nullable = false)
    private Boolean official;
}
