package com.proyectosi1.apirest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class BodegaEntity {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String descripcion;
    @Column(nullable = false)
    private Integer capacidad;
}
