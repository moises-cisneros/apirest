package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(EgresoProductoId.class)
@Entity 
@Table (name = "EGRESO_PRODUCTO")
public class EgresoProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingreso_producto_gen")
    @SequenceGenerator(name = "ingreso_producto_gen")
    private Integer id;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_nota_egreso")
    private NotaEgresoEntity id_nota_egreso;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private TallaEntity talla;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

}
