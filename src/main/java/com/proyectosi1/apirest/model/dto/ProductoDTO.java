package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private ColorDTO color;
    private CategoryDTO categoria;
    private MarcaDTO marca;
    private DescuentoDTO descuento;
}
