package com.proyectosi1.apirest.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraQueryDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private String usuario;
}
