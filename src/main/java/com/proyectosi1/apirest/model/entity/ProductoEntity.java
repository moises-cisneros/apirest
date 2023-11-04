package com.proyectosi1.apirest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "PRODUCTO")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombre;
    @Column(length = 150)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoryEntity categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private MarcaEntity marca;
    
}