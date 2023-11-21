package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagenDTO {
    private Integer id;
    private String url;
    private Integer idInventario;
}
