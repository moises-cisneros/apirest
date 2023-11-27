package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColoresDTO {
    private int id;
    private String nombre;
    private String url;
    private boolean disponible;
    private Integer idProducto;
    private List<TallaDTO> tallas;
}
