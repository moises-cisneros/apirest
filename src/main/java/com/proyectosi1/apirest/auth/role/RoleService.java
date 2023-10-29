package com.proyectosi1.apirest.auth.role;

import com.proyectosi1.apirest.auth.permission.PermissionEntity;
import com.proyectosi1.apirest.auth.permission.PermissionRepository;
import com.proyectosi1.apirest.auth.user.UserEntity;
import com.proyectosi1.apirest.dto.RolePermissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleEntity createRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public RoleEntity updateRole(RoleEntity role) {
        return roleRepository.save((role));
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    public RoleEntity getRole(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<RoleEntity> getAllRole() {
        return roleRepository.findAll();
    }

    public RoleEntity addListPermisos (RolePermissionDTO rolePermissionDTO) {
        RoleEntity roleEntity = roleRepository.findByName(rolePermissionDTO.getNameRole());

        for (String permissionName : rolePermissionDTO.getPermissions()) {
            PermissionEntity permission = permissionRepository.findByNombre(permissionName);
            if (permission != null) {
                roleEntity.getPermisos().add(permission);
            }
        }

        return roleRepository.save(roleEntity);
    }
}
