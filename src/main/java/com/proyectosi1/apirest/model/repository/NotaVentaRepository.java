package com.proyectosi1.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVentaEntity, Integer> {

    // Obtener la cantidad total de elementos en la tabla nota_venta
    @Query(value = "SELECT COUNT(*) FROM nota_venta", nativeQuery = true)
    Integer countAll();


    @Modifying
    @Query(value = "\n" +
            "CREATE TRIGGER IF NOT EXISTS actualizar_inventario_por_nota_pagado AFTER UPDATE ON nota_venta\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "\n" +
            "  IF NEW.estado = 'Pagado' THEN\n" +
            "    UPDATE inventario i\n" +
            "    JOIN detalle_venta d ON i.id = d.id_inventario\n" +
            "    SET i.cantidad = i.cantidad - d.cantidad\n" +
            "    WHERE d.id_nota = NEW.id;\n" +
            "  END IF;\n" +
            "END", nativeQuery = true)
    void crearTrigger();

}
