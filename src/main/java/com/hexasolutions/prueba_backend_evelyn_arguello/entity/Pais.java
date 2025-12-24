package com.hexasolutions.prueba_backend_evelyn_arguello.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "pais",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codigo")
        }
)
@Data
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;
}
