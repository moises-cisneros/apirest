package com.proyectosi1.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnvioProductoTallaDTO {

    List<ProductoDTO> productos;
    List<TallaDTO> tallas;

}
