package com.proyectosi1.apirest.product.ingreso_producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoEntity;

@Repository
public interface IngresoProductoRepository extends JpaRepository<IngresoProductoEntity,Integer>{
    /*@Query("SELECT MAX(i.id) FROM ingreso_producto as i")
    Integer findMaxId();*/
}
