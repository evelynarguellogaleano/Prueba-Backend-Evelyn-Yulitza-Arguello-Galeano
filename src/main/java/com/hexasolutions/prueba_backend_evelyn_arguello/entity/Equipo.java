package com.hexasolutions.prueba_backend_evelyn_arguello.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "equipo",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codigo")
        }
)
@Data
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "liga_id", nullable = false)
    private Liga liga;
}
