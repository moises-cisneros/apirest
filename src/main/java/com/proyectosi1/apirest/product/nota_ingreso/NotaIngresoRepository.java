package com.proyectosi1.apirest.product.nota_ingreso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoEntity;

@Repository
public interface NotaIngresoRepository extends JpaRepository<NotaIngresoEntity,Integer>{
    NotaIngresoEntity saveAndFlush(NotaIngresoEntity entity);
}