package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Pais;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los Países.
 */
@RestController
@RequestMapping("/paises")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    /**
     * Crea un nuevo pais
     *
     * @param pais Objeto con la información del pais a crear
     * @return El pais creado
     */
    @PostMapping
    public Pais crear(@RequestBody Pais pais) {
        return paisService.crear(pais);
    }

    /**
     * Lista todos los países registrados
     *
     * @return Lista de países
     */
    @GetMapping
    public List<Pais> listar() {
        return paisService.listar();
    }

    /**
     * Obtiene un país por su ID
     *
     * @param id ID del país a buscar
     * @return El país encontrado
     */
    @GetMapping("/{id}")
    public Pais obtenerPorId(@PathVariable Long id) {
        return paisService.obtenerPorId(id);
    }

    /**
     * Actualiza la información de un país existente
     *
     * @param id   ID del país a actualizar
     * @param pais Objeto con la nueva información del país
     * @return El país actualizado
     */
    @PutMapping("/{id}")
    public Pais actualizar(@PathVariable Long id, @RequestBody Pais pais) {
        return paisService.actualizar(id, pais);
    }
}
