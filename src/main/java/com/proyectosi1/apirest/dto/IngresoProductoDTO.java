package com.proyectosi1.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngresoProductoDTO {
    //Integer id_nota;
    Integer cantidad;
    Integer id_producto;
    Integer id_talla;
}
