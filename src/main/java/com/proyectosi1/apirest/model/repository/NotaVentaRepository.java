package com.proyectosi1.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVentaEntity, Integer> {

    // Obtener la cantidad total de elementos en la tabla nota_venta
    @Query(value = "SELECT COUNT(*) FROM nota_venta", nativeQuery = true)
    Integer countAll();

}
