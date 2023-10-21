package com.proyectosi1.apirest.repository;

import com.proyectosi1.apirest.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {
}
