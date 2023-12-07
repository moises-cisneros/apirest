package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CatalogoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private DescuentoDTO descuento;
    private ColorDTO color;
    private MarcaDTO marca;
    private CategoryDTO categoria;
    private String url;
    private List<DetalleTallaDTO> detalleTalla;

}
