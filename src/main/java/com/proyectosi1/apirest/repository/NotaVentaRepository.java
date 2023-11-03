package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.NotaVentaEntity;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVentaEntity, Integer> {
    
}
