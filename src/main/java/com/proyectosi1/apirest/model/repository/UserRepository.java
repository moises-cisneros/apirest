package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // Consulta: Busca el usuario mediante username
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "select permiso.nombre from usuario,rol,rol_permiso,permiso where usuario.id=2 and usuario.id_rol=rol.id and  rol.id=rol_permiso.id_rol and rol_permiso.id_permiso=permiso.id", nativeQuery = true)
    List<RoleEntity> ObtenerRolUsers();

}
