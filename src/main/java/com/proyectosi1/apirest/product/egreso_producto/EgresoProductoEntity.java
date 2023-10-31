package com.proyectosi1.apirest.product.egreso_producto;

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
@Table (name = "EGRESO_PRODUCTO")
public class EgresoProductoEntity {

    @EmbeddedId
    private EgresoProductoId id;

    @MapsId("id_nota_egreso")
    @ManyToOne
    @JoinColumn(name = "id_nota_egreso")
    private NotaIngresoEntity id_nota_egreso;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private TallaEntity talla;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

}
