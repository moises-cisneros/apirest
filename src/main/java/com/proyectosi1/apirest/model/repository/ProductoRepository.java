package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.model.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query("SELECT prd FROM ProductoEntity prd WHERE prd.nombre = :name")
    Iterable<ProductoEntity> finByNombre(String name);

    @Query("SELECT prd.color FROM ProductoEntity prd WHERE prd.nombre = :name")
    Iterable<ColorEntity> findByNameProductAllColors(String name);

}
