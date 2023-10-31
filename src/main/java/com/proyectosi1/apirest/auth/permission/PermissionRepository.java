package com.proyectosi1.apirest.auth.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

    PermissionEntity findByNombre(String permissionName);
}
