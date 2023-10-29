package com.proyectosi1.apirest.product.egreso_producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.product.egreso_producto.EgresoProductoEntity;

@Repository
public interface EgresoProductoRepository extends JpaRepository<EgresoProductoEntity,Integer>{
    
}