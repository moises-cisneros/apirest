package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CatalogoDTO {

    private Integer id;
    private String nombreProducto;
    private String url;
    private Float precio;
    private Integer stock;

}
