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
public class IngresoProductoEntity {

    @EmbeddedId
    private IngresoProductoId id;

    public void setId(IngresoProductoId id) {
        this.id = id;
    }

    @MapsId("id_nota_ingreso")
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
