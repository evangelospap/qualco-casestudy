package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false , unique = true)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> countries;
}
