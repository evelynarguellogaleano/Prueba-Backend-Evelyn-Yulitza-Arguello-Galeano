package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Equipo;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los Equipos
 */
@RestController
@RequestMapping("/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    /**
     * Crea un nuevo equipo
     *
     * @param equipo Objeto con la información del equipo a crear
     * @return El equipo creado
     */
    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.crear(equipo);
    }

    /**
     * Lista todos los equipos registrados
     *
     * @return Lista de equipos
     */
    @GetMapping
    public List<Equipo> listar() {
        return equipoService.listar();
    }

    /**
     * Obtiene un equipo por su ID
     *
     * @param id ID del equipo a buscar
     * @return El equipo encontrado
     */
    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    /**
     * Lista los equipos que pertenecen a una liga específica
     *
     * @param ligaId ID de la liga
     * @return Lista de equipos pertenecientes a la liga
     */
    @GetMapping("/liga/{ligaId}")
    public List<Equipo> listarPorLiga(@PathVariable Long ligaId) {
        return equipoService.listarPorLiga(ligaId);
    }

    /**
     * Actualiza la información de un equipo existente
     *
     * @param id     ID del equipo a actualizar
     * @param equipo Objeto con la nueva información del equipo
     * @return El equipo actualizado
     */
    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.actualizar(id, equipo);
    }
}
