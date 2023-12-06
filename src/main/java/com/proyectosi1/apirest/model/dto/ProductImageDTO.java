package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ProductImageDTO {
    private Integer id;
    private String nombre;
    private List<ColoresDTO> colores;
}
