package com.proyectosi1.apirest.product.nota_ingreso;

import java.util.Date;

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
@Table (name = "NOTA_INGRESO")
public class NotaIngresoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fecha;   
    private Integer cantidad_total;

}
