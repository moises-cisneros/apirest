package com.proyectosi1.apirest.product.ingreso_producto;

import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoEntity;
import com.proyectosi1.apirest.entity.ProductoEntity;
import com.proyectosi1.apirest.entity.TallaEntity;
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
@IdClass(IngresoProductoId.class)
public class IngresoProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingreso_producto_gen")
    @SequenceGenerator(name = "ingreso_producto_gen")
    private Integer id;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_nota_ingreso")
    private NotaIngresoEntity id_nota_ingreso;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private TallaEntity talla;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

}
