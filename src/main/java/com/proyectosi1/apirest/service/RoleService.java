package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.dto.RolePermissionDTO;
import com.proyectosi1.apirest.model.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public RoleEntity addListPermissions (RolePermissionDTO rolePermissionDTO) {
        RoleEntity roleEntity = roleRepository.findByName(rolePermissionDTO.getNameRole());

        List<PermissionEntity> auxPermissionsList = new ArrayList<>(roleEntity.getPermisos());

        // Agregar o actualizar los permisos
        for (String permissionName : rolePermissionDTO.getPermissions()) {
            PermissionEntity permission = permissionRepository.findByNombre(permissionName);
            if (permission != null) {
                if (!roleEntity.getPermisos().contains(permission)) {
                    roleEntity.getPermisos().add(permission);
                }
            }
        }

        // Eliminar permisos que fueron quitados del rol
        for (PermissionEntity auxPermission : auxPermissionsList) {
            if (!rolePermissionDTO.getPermissions().contains(auxPermission.getNombre())) {
                roleEntity.getPermisos().remove(auxPermission);
            }
        }

        return roleRepository.save(roleEntity);
    }
}
