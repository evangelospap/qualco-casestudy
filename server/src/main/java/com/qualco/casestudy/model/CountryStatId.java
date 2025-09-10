package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatId implements Serializable {
    @Column(name = "country_id", nullable = false)
    private Integer countryId;
    @Column(name = "year", nullable = false)
    private Integer year;
}
