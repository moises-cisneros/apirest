package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoVentaDTO {
    private Integer nroNotaVenta;
    private String nombreCliente;
    private String estadoVenta;
}
