package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.dto.LigaDTO;
import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Liga;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.LigaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligas")
@RequiredArgsConstructor
public class LigaController {

    private final LigaService ligaService;

    // Crear liga
    @PostMapping
    public Liga crear(@RequestBody Liga liga) {
        return ligaService.crear(liga);
    }

    // Listar todas
    @GetMapping
    public List<LigaDTO> listar() {
        return ligaService.listar();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public LigaDTO obtenerPorId(@PathVariable Long id) {
        return ligaService.obtenerPorId(id);
    }

    // Listar por país (FK)
    @GetMapping("/pais/{paisId}")
    public List<LigaDTO> listarPorPais(@PathVariable Long paisId) {
        return ligaService.listarPorPais(paisId);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Liga actualizar(@PathVariable Long id, @RequestBody Liga liga) {
        return ligaService.actualizar(id, liga);
    }
}
