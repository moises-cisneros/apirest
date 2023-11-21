package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.NotaIngresoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaIngresoRepository extends JpaRepository<NotaIngresoEntity,Integer>{
    NotaIngresoEntity saveAndFlush(NotaIngresoEntity entity);
}