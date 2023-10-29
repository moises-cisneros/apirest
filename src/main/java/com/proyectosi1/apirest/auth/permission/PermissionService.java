package com.proyectosi1.apirest.auth.permission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
