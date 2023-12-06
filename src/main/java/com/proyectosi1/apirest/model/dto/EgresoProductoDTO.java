package com.proyectosi1.apirest.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EgresoProductoDTO {
    private Integer cantidad;
    private Integer id_producto;
    private Integer id_talla;
}
