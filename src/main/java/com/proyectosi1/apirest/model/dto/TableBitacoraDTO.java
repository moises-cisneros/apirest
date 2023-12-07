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
public class TableBitacoraDTO {
    private Integer id;
    private String user;
    private String accion;
    private String fecha;
    private String hora;
}
