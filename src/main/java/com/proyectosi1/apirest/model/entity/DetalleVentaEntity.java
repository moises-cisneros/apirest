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

}
