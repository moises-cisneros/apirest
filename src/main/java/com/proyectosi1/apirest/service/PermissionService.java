package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.dto.PermissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionEntity createPermission(PermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    public PermissionEntity updatePermission(PermissionEntity permission) {
        return permissionRepository.save((permission));
    }

    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }

    public PermissionEntity getPermission(Integer id) {
        return permissionRepository.findById(id).orElse(null);
    }

    public List<PermissionEntity> getAllPermission() {
        return permissionRepository.findAll();
    }

    // Obtener una lista de: permisos y lista de roles
    public List<PermissionDTO> getAllPermissions() {
        List<PermissionDTO> listPermission = new ArrayList<>();

        for (PermissionEntity permissionEntity : permissionRepository.findAll()) {
            PermissionDTO permission = new PermissionDTO();
            permission.setNombre(permissionEntity.getNombre());

            List<String> listRoles = new ArrayList<>();
            for (RoleEntity role : permissionEntity.getRoles()) {
                listRoles.add(role.getName());
            }

            permission.setRoles(listRoles);
            listPermission.add(permission);
        }

        return listPermission;
    }
}
