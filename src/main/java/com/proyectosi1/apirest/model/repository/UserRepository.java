package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Consulta: Busca el usuario mediante username
    Optional<UserEntity> findByUsername(String username);
}
