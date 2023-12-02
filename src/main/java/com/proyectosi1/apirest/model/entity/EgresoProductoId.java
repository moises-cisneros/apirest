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
public class EgresoProductoId implements Serializable {
    private Integer id_nota_egreso;
    private Integer id;
}
