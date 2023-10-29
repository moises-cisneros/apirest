package com.proyectosi1.apirest.product.ingreso_producto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class IngresoProductoId implements Serializable {
    private Integer id_nota_ingreso;
    private Integer id;
}
