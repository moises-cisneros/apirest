package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.EgresoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgresoProductoRepository extends JpaRepository<EgresoProductoEntity,Integer>{
    
}