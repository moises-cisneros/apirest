package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductoDTO {
    String nombre;
    String descripcion;
    Integer id_color;
    Integer id_categoria;
    Integer id_marca;
}
