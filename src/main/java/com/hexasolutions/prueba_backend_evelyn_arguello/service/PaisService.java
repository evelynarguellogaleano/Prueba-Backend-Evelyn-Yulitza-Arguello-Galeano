package com.hexasolutions.prueba_backend_evelyn_arguello.service;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Pais;
import com.hexasolutions.prueba_backend_evelyn_arguello.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    // Crear país
    public Pais crear(Pais pais) {
        if (paisRepository.existsByCodigo(pais.getCodigo())) {
            throw new RuntimeException("Ya existe un país con el código: " + pais.getCodigo());
        }
        return paisRepository.save(pais);
    }

    // Listar todos
    public List<Pais> listar() {
        return paisRepository.findAll();
    }

    // Obtener por ID
    public Pais obtenerPorId(Long id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado con id: " + id));
    }

    // Actualizar
    public Pais actualizar(Long id, Pais pais) {
        Pais existente = obtenerPorId(id);

        // Si cambia el código, validar que no exista
        if (!existente.getCodigo().equals(pais.getCodigo())
                && paisRepository.existsByCodigo(pais.getCodigo())) {
            throw new RuntimeException("El código del país ya existe");
        }

        existente.setCodigo(pais.getCodigo());
        existente.setNombre(pais.getNombre());

        return paisRepository.save(existente);
    }
}
