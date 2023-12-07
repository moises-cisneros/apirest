package com.proyectosi1.apirest.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectosi1.apirest.model.entity.BitacoraEntity;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraEntity, Integer> {
    List<BitacoraEntity> findByFechaBetween(Date startDate, Date endDate);    
}
