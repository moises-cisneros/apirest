package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.BodegaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<BodegaEntity, Integer> {
    
}
