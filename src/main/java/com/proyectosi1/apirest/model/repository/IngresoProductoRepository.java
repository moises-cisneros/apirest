package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.IngresoProductoEntity;
import com.proyectosi1.apirest.model.entity.IngresoProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IngresoProductoRepository extends JpaRepository<IngresoProductoEntity, IngresoProductoId>{
    @Modifying
    @Query(value = "CREATE TRIGGER IF NOT EXISTS tr_actualizar_o_crear_inventario " +
            "AFTER INSERT ON ingreso_producto " +
            "FOR EACH ROW " +
            "BEGIN " +
            "   DECLARE producto_existente INT; " +
            "   SELECT 1 INTO producto_existente " +
            "   FROM inventario " +
            "   WHERE id_producto = NEW.id_producto and id_talla = NEW.id_talla; " +
            "   IF producto_existente IS NULL THEN " +
            "       INSERT INTO inventario (precio, cantidad, id_producto, id_talla, id_bodega) " +
            "       VALUES (1, NEW.cantidad, NEW.id_producto, NEW.id_talla, null); " +
            "   ELSE " +
            "       UPDATE inventario " +
            "       SET cantidad = cantidad + NEW.cantidad " +
            "       WHERE id_producto = NEW.id_producto and id_talla = NEW.id_talla; " +
            "   END IF; " +
            "END", nativeQuery = true)
    void crearTrigger();

}
