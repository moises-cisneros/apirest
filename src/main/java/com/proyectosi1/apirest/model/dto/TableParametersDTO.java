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
    String nombre;
    String talla;
    Integer cantidad;
    float precio;
    float subtotal;
    String descuento;
}
