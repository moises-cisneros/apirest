package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.Nota_IngresoEntity;

@Repository
public interface Nota_IngresoRepository extends JpaRepository<Nota_IngresoEntity,Integer>{
    
}