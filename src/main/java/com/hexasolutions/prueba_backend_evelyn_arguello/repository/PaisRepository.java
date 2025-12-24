package com.hexasolutions.prueba_backend_evelyn_arguello.repository;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    boolean existsByCodigo(String codigo);
}
