package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.Ingreso_ProductoEntity;

@Repository
public interface Ingreso_ProductoRepository extends JpaRepository<Ingreso_ProductoEntity,Integer>{
    
}
