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
@Table(name = "detalle_venta")
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_nota")
    private NotaVentaEntity notaVenta;

    @ManyToOne
    @JoinColumn(name = "id_inventario")
    private InventarioEntity inventario;

    // Obtener los datos para el reporte de la nota de venta
/*
    public String getNombre() {
        return inventario.getProducto().getNombre();
    }

    public String getTalla() {
        return inventario.getTalla().getTalla();
    }

    public float getPrecio() {
        return inventario.getPrecio();
    }

    public float getSubtotal() {
        return cantidad * inventario.getPrecio();
    }

    public String getDescuento() {
        return inventario.getProducto().getDescuento().getDescripcion();
    }*/
}
