package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {

    @Query("SELECT dv FROM DetalleVentaEntity dv WHERE dv.notaVenta.id = :idNotaVenta")
    Iterable<DetalleVentaEntity> findByVenta(Integer idNotaVenta);
    @Modifying
    @Query(value = "CREATE TRIGGER IF NOT EXISTS tr_actualizar_monto_total " +
            "AFTER INSERT ON detalle_venta " +
            "FOR EACH ROW " +
            "BEGIN " +
            "   DECLARE total_monto FLOAT; " +

            "   SELECT SUM(dv.cantidad * i.precio) INTO total_monto " +
            "   FROM detalle_venta dv " +
            "   INNER JOIN inventario i ON dv.id_inventario = i.id " +
            "   WHERE dv.id_nota = NEW.id_nota; " +

            "   UPDATE nota_venta " +
            "   SET monto = total_monto " +
            "   WHERE id = NEW.id_nota; " +
            "END", nativeQuery = true)
    void crearTrigger();

}
