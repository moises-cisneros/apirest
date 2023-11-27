package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.TallaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectosi1.apirest.model.entity.InventarioEntity;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

    @Query("SELECT inv FROM InventarioEntity inv WHERE inv.producto.id = :idProducto")
    Iterable<InventarioEntity> findByProducto(Integer idProducto);

    @Query("SELECT inv.talla FROM InventarioEntity inv WHERE inv.producto.id = :idProducto")
    Iterable<TallaEntity> findByProductIdAllTallas(Integer idProducto);

}


