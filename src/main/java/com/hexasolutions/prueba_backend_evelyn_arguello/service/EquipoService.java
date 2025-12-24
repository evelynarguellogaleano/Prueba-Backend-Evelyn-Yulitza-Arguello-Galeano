package com.hexasolutions.prueba_backend_evelyn_arguello.service;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Equipo;
import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Liga;
import com.hexasolutions.prueba_backend_evelyn_arguello.repository.EquipoRepository;
import com.hexasolutions.prueba_backend_evelyn_arguello.repository.LigaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;
    private final LigaRepository ligaRepository;

    public Equipo crear(Equipo equipo) {

        if (equipoRepository.existsByCodigo(equipo.getCodigo())) {
            throw new RuntimeException("Ya existe un equipo con ese código");
        }

        Liga liga = ligaRepository.findById(equipo.getLiga().getId())
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));

        equipo.setLiga(liga);
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    public List<Equipo> listarPorLiga(Long ligaId) {
        return equipoRepository.findByLigaId(ligaId);
    }

    public Equipo actualizar(Long id, Equipo equipo) {

        Equipo existente = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        if (!existente.getCodigo().equals(equipo.getCodigo())
                && equipoRepository.existsByCodigo(equipo.getCodigo())) {
            throw new RuntimeException("El código ya existe");
        }

        Liga liga = ligaRepository.findById(equipo.getLiga().getId())
                .orElseThrow(() -> new RuntimeException("Liga no encontrada"));

        existente.setCodigo(equipo.getCodigo());
        existente.setNombre(equipo.getNombre());
        existente.setLiga(liga);

        return equipoRepository.save(existente);
    }
}
