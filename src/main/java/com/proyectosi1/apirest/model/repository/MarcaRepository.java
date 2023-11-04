package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {
    
}
