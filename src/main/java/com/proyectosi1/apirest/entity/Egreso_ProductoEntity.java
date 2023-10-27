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
@Table (name = "EGRESO_PRODUCTO")
public class Egreso_ProductoEntity {
    @Id
    @GeneratedValue
    private Integer id;


    private Integer cantidad;
    private String talla;

    @ManyToOne
    @JoinColumn(name = "id_nota_egreso")
    private Nota_EgresoEntity idNota_egreso;       
}
