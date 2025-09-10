package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "region_areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionArea {

    @Id
    @Column(name = "region_name",  nullable = false , unique = true, length = 100)
    private String name;

    @Column(name = "region_area", nullable = false)
    private Double area;
}
