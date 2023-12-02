package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.ProductoEntity;
import com.proyectosi1.apirest.model.entity.TallaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectosi1.apirest.model.entity.InventarioEntity;

import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

    // Devuelve todos los registros del inventario que perteneciente a un producto
    @Query("SELECT inv FROM InventarioEntity inv WHERE inv.producto.id = :idProducto")
    Iterable<InventarioEntity> findByProducto(Integer idProducto);

    // Devuelve un iterable de todas las tallas perteneciente a un producto color
    @Query("SELECT inv.talla FROM InventarioEntity inv WHERE inv.producto.id = :idProducto")
    Iterable<TallaEntity> findByProductIdAllTallas(Integer idProducto);

}


