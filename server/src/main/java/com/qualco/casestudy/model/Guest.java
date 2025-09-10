package com.qualco.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "guests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id", nullable = false , unique = true)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;
}
