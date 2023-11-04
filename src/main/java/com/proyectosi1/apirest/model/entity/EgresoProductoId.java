package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;

@Embeddable
public class EgresoProductoId implements Serializable {
    private Integer id_nota_egreso;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
