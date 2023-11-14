package com.proyectosi1.apirest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotaVentaDTO {

    private Integer id;
    private String estado;
    private String user;
    private String fecha;
    private float monto;

}
