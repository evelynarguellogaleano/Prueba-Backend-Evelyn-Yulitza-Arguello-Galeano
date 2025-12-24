package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Pais;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    // Crear país
    @PostMapping
    public Pais crear(@RequestBody Pais pais) {
        return paisService.crear(pais);
    }

    // Listar todos
    @GetMapping
    public List<Pais> listar() {
        return paisService.listar();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public Pais obtenerPorId(@PathVariable Long id) {
        return paisService.obtenerPorId(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Pais actualizar(@PathVariable Long id, @RequestBody Pais pais) {
        return paisService.actualizar(id, pais);
    }
}
