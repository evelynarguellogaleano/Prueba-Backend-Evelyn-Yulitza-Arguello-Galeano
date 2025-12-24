package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Equipo;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.crear(equipo);
    }

    @GetMapping
    public List<Equipo> listar() {
        return equipoService.listar();
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    @GetMapping("/liga/{ligaId}")
    public List<Equipo> listarPorLiga(@PathVariable Long ligaId) {
        return equipoService.listarPorLiga(ligaId);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.actualizar(id, equipo);
    }
}
