package com.proyectosi1.apirest.dto;

import com.proyectosi1.apirest.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotaIngresoDTO {
    String descripcion;
    Date fecha;
    List<ProductoDTO> productos;
}
