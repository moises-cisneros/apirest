package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.NotaEgresoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEgresoRepository extends JpaRepository<NotaEgresoEntity,Integer>{
    
}