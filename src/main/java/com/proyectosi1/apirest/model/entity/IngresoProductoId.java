package com.proyectosi1.apirest.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IngresoProductoId implements Serializable {
    private Integer id_nota_ingreso;
    private Integer id;

}
