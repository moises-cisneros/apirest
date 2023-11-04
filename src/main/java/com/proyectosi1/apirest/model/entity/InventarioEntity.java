package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "INVENTARIO")
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private float precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private TallaEntity talla;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @ManyToOne
    @JoinColumn(name = "id_bodega")
    private BodegaEntity bodega;

}
