package com.hexasolutions.prueba_backend_evelyn_arguello.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "liga",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codigo")
        }
)
@Data
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;
}
