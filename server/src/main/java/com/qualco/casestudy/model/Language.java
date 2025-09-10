package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false , unique = true)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String language;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<CountryLanguage> countries;
}
