package com.qualco.casestudy.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VIP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vip_id",  nullable = false , unique = true)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;
}
