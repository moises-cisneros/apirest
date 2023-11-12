package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableParametersDTO {
    private String nombre;
    private String talla;
    private Integer cantidad;
    private float precio;
    private float subtotal;
    private String descuento;
}
