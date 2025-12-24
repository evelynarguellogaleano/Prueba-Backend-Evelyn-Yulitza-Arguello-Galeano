package com.hexasolutions.prueba_backend_evelyn_arguello.service;

import com.hexasolutions.prueba_backend_evelyn_arguello.dto.LigaDTO;
import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Liga;
import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Pais;
import com.hexasolutions.prueba_backend_evelyn_arguello.repository.LigaRepository;
import com.hexasolutions.prueba_backend_evelyn_arguello.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LigaService {

    private final LigaRepository ligaRepository;
    private final PaisRepository paisRepository;

    // Crear liga
    public Liga crear(Liga liga) {
        if (ligaRepository.existsByCodigo(liga.getCodigo())) {
            throw new RuntimeException("Ya existe una liga con el código: " + liga.getCodigo());
        }

        // Validar país
        Pais pais = paisRepository.findById(liga.getPais().getId())
                .orElseThrow(() -> new RuntimeException("País no encontrado"));

        liga.setPais(pais);
        return ligaRepository.save(liga);
    }

    // Listar todas
    public List<LigaDTO> listar() {
        return ligaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // Obtener por id
    public LigaDTO obtenerPorId(Long id) {
        Liga liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));

        return toDTO(liga);
    }

    // Listar por país (FK)
    public List<LigaDTO> listarPorPais(Long paisId) {
        return ligaRepository.findByPaisId(paisId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // Actualizar
    public Liga actualizar(Long id, Liga liga) {
        Liga existente = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));

        if (!existente.getCodigo().equals(liga.getCodigo())
                && ligaRepository.existsByCodigo(liga.getCodigo())) {
            throw new RuntimeException("El código de la liga ya existe");
        }

        Pais pais = paisRepository.findById(liga.getPais().getId())
                .orElseThrow(() -> new RuntimeException("País no encontrado"));

        existente.setCodigo(liga.getCodigo());
        existente.setNombre(liga.getNombre());
        existente.setPais(pais);

        return ligaRepository.save(existente);
    }

    private LigaDTO toDTO(Liga liga) {
        return new LigaDTO(
                liga.getId(),
                liga.getCodigo(),
                liga.getNombre(),
                liga.getPais().getCodigo(),
                liga.getPais().getNombre()
        );
    }
}
