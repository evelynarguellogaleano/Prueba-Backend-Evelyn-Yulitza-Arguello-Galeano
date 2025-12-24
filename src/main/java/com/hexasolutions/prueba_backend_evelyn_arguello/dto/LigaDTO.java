package com.hexasolutions.prueba_backend_evelyn_arguello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LigaDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String codigoPais;
    private String nombrePais;
}
