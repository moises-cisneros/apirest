package com.proyectosi1.apirest.entity;

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
@Table (name = "NOTA_EGRESO")
public class Nota_EgresoEntity {
    @Id
    @GeneratedValue
    private Integer id;


    private String descripcion;
    private Date fecha;
    private Integer cantidad_total;

}
