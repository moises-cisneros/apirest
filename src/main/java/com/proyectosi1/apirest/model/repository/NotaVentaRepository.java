package com.proyectosi1.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;

import java.util.Optional;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVentaEntity, Integer> {

}
