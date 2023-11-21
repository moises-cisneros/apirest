package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.IngresoProductoEntity;
import com.proyectosi1.apirest.model.entity.IngresoProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoProductoRepository extends JpaRepository<IngresoProductoEntity, IngresoProductoId>{
    
}
