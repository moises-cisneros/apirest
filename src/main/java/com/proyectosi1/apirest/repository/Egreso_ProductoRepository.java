package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.Egreso_ProductoEntity;

@Repository
public interface Egreso_ProductoRepository extends JpaRepository<Egreso_ProductoEntity,Integer>{
    
}