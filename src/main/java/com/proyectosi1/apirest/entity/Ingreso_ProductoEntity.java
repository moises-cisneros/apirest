package com.proyectosi1.apirest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "INGRESO_PRODUCTO")
public class Ingreso_ProductoEntity {
    @Id
    @GeneratedValue
    private Integer id;


    private Integer cantidad;
    private String talla;

    @ManyToOne
    @JoinColumn(name = "id_nota_ingreso")
    private Nota_IngresoEntity id_nota_ingreso;

}
