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
public class MarcaEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nombre;
    private String pais;

}
