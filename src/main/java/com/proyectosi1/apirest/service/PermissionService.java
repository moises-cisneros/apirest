package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.mapper.PermissionMapper;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.dto.PermissionNameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

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
    /*
    public List<PermissionNameDTO> getAllPermissions() {
        return permissionMapper.getAllPermissions();
    }*/
}
