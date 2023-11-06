package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.RolPermisoDTO;
import com.proyectosi1.apirest.model.dto.RolePermissionDTO;
import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    // Dado un rol, le agrega todos los permisos asignados
    public RoleEntity addListPermissions(RolePermissionDTO rolePermissionDTO) {
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

    // Devuelve una lista de las IDs del rol y permiso
    public List<RolPermisoDTO> getRolPermiso() {
        List<RolPermisoDTO> rolPermisoDTOList = new ArrayList<>();

        for (RoleEntity roleEntity: roleRepository.findAll()) {
            for (PermissionEntity permissionEntity: roleEntity.getPermisos()) {
                RolPermisoDTO rolPermisoDTO = new RolPermisoDTO();

                rolPermisoDTO.setIdRol(roleEntity.getId());
                rolPermisoDTO.setIdPermiso(permissionEntity.getId());

                rolPermisoDTOList.add(rolPermisoDTO);
            }
        }

        return rolPermisoDTOList;
    }
}
