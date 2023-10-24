package com.proyectosi1.apirest.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectosi1.apirest.entity.ProductoDisponibleEntity;

@Repository
public interface ProductoDisponibleRepository extends JpaRepository<ProductoDisponibleEntity, Integer> {

}


