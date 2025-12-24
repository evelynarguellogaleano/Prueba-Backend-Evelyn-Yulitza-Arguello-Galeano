package com.hexasolutions.prueba_backend_evelyn_arguello.repository;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    boolean existsByCodigo(String codigo);

    List<Equipo> findByLigaId(Long ligaId);
}
