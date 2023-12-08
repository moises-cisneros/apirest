package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.EgresoProductoEntity;
import com.proyectosi1.apirest.model.entity.EgresoProductoId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EgresoProductoRepository extends JpaRepository<EgresoProductoEntity,EgresoProductoId>{
    @Modifying
    @Query(value = "CREATE TRIGGER IF NOT EXISTS tr_descontar_inventario_egreso\n" +
            "AFTER INSERT ON EGRESO_PRODUCTO\n" +
            "FOR EACH ROW\n" +
            "BEGIN\n" +
            "   DECLARE producto_existente INT;\n" +
            "    \n" +
            "    SELECT 1 INTO producto_existente\n" +
            "    FROM INVENTARIO\n" +
            "    WHERE id_producto = NEW.id_producto and id_talla = NEW.id_talla;\n" +
            "    \n" +
            "    IF producto_existente IS NULL THEN\n" +
            "        INSERT INTO INVENTARIO (precio, cantidad, id_producto, id_talla, id_bodega)\n" +
            "        VALUES (1, NEW.cantidad, NEW.id_producto, NEW.id_talla, null);\n" +
            "    ELSE\n" +
            "        UPDATE INVENTARIO\n" +
            "        SET cantidad = cantidad - NEW.cantidad\n" +
            "        WHERE id_producto = NEW.id_producto and id_talla = NEW.id_talla;\n" +
            "    END IF;\n" +
            "END", nativeQuery = true)
    void crearTrigger();
}