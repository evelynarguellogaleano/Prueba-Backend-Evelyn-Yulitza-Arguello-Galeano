package com.hexasolutions.prueba_backend_evelyn_arguello.repository;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Liga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigaRepository extends JpaRepository<Liga, Long> {

    boolean existsByCodigo(String codigo);

    List<Liga> findByPaisId(Long paisId);

    List<Liga> findByPaisNombreContainingIgnoreCase(String texto);
}
