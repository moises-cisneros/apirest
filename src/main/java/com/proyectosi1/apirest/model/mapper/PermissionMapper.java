package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.PermissionNameDTO;
import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermissionMapper {

    @Autowired
    private PermissionRepository permissionRepository;

    // Obtener una lista de: permisos y lista de roles
    public List<PermissionNameDTO> getAllPermissions() {
        List<PermissionNameDTO> listPermission = new ArrayList<>();

        for (PermissionEntity permissionEntity : permissionRepository.findAll()) {
            PermissionNameDTO permission = new PermissionNameDTO();
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
