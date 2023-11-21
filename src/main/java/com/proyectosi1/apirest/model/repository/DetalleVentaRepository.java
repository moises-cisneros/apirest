package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {

    @Query("SELECT dv FROM DetalleVentaEntity dv WHERE dv.notaVenta.id = :idNotaVenta")
    Iterable<DetalleVentaEntity> findByVenta(Integer idNotaVenta);

}
