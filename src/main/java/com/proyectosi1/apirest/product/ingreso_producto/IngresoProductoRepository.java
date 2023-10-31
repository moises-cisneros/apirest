package com.proyectosi1.apirest.product.ingreso_producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoProductoRepository extends JpaRepository<IngresoProductoEntity, IngresoProductoId>{
    
}
