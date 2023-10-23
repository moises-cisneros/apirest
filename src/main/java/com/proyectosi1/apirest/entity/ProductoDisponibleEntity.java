package com.proyectosi1.apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTO_DISPONIBLE")
public class ProductoDisponibleEntity {

    @Id
    @GeneratedValue
    private Integer id;    
    private float precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private StockTallaEntity talla;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    
}
