package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.ImagenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagenRepository extends JpaRepository<ImagenEntity, Integer> {
    List<ImagenEntity> findByInventarioId(Integer inventarioId);
}

