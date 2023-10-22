package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectosi1.apirest.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    
}
