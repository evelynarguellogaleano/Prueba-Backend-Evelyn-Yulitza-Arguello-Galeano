package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import com.hexasolutions.prueba_backend_evelyn_arguello.dto.LigaDTO;
import com.hexasolutions.prueba_backend_evelyn_arguello.entity.Liga;
import com.hexasolutions.prueba_backend_evelyn_arguello.service.LigaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con las Ligas
 */
@RestController
@RequestMapping("/ligas")
@RequiredArgsConstructor
public class LigaController {

    private final LigaService ligaService;

    /**
     * Crea una nueva liga
     *
     * @param liga Objeto con la información de la liga a crear
     * @return La liga creada
     */
    @PostMapping
    public Liga crear(@RequestBody Liga liga) {
        return ligaService.crear(liga);
    }

    /**
     * Lista todas las ligas registradas en formato DTO
     *
     * @return Lista de ligas (DTO)
     */
    @GetMapping
    public List<LigaDTO> listar() {
        return ligaService.listar();
    }

    /**
     * Obtiene una liga por su ID en formato DTO
     *
     * @param id ID de la liga a buscar
     * @return La liga encontrada (DTO)
     */
    @GetMapping("/{id}")
    public LigaDTO obtenerPorId(@PathVariable Long id) {
        return ligaService.obtenerPorId(id);
    }

    /**
     * Lista las ligas que pertenecen a un país específico
     *
     * @param paisId ID del país
     * @return Lista de ligas (DTO) pertenecientes al país
     */
    @GetMapping("/pais/{paisId}")
    public List<LigaDTO> listarPorPais(@PathVariable Long paisId) {
        return ligaService.listarPorPais(paisId);
    }

    /**
     * Actualiza la información de una liga existente
     *
     * @param id   ID de la liga a actualizar
     * @param liga Objeto con la nueva información de la liga
     * @return La liga actualizada
     */
    @PutMapping("/{id}")
    public Liga actualizar(@PathVariable Long id, @RequestBody Liga liga) {
        return ligaService.actualizar(id, liga);
    }
}
