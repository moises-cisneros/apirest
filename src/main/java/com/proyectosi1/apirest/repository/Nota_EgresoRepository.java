package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.Nota_EgresoEntity;

@Repository
public interface Nota_EgresoRepository extends JpaRepository<Nota_EgresoEntity,Integer>{
    
}