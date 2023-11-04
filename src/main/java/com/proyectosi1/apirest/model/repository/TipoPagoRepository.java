package com.proyectosi1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.entity.TipoPagoEntity;

@Repository
public interface TipoPagoRepository extends JpaRepository <TipoPagoEntity, Integer> {
    
}
