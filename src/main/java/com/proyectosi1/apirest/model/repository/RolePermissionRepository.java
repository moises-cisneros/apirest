package com.proyectosi1.apirest.model.repository;

import com.proyectosi1.apirest.model.entity.RolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

    @Query("SELECT rp FROM RolePermissionEntity rp WHERE rp.rol.id = :idRol")
    Iterable<RolePermissionEntity> findByPermiso(Integer idRol);
}
