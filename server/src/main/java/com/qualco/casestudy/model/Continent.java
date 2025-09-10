package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "continents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id", nullable = false , unique = true)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private List<Region> regions;
}
