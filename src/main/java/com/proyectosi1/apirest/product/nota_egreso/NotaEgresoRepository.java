package com.proyectosi1.apirest.product.nota_egreso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.product.nota_egreso.NotaEgresoEntity;

@Repository
public interface NotaEgresoRepository extends JpaRepository<NotaEgresoEntity,Integer>{
    
}