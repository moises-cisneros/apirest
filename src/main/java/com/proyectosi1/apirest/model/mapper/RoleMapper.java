package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.RolPermisoDTO;
import com.proyectosi1.apirest.model.dto.RolePermissionDTO;
import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.entity.RolePermissionEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.repository.RolePermissionRepository;
import com.proyectosi1.apirest.model.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    // Dado un rol, le agrega todos los permisos asignados
    public void addListPermissions(RolePermissionDTO rolePermissionDTO) {
        RoleEntity roleEntity = roleRepository.findByName(rolePermissionDTO.getNameRole());
        List<RolePermissionEntity> rolePermissionEntityList = (List<RolePermissionEntity>) rolePermissionRepository.findByPermiso(roleEntity.getId());

        // Obtener todas las instancias de PermissionEntity
        List<PermissionEntity> allPermissions = permissionRepository.findAll();

        // Eliminar permisos que fueron quitados del rol
        rolePermissionEntityList.stream()
                .filter(rolePermissionEntity -> !rolePermissionDTO.getPermissions().contains(rolePermissionEntity.getPermiso().getNombre()))
                .forEach(rolePermissionRepository::delete);

        // Agregar o actualizar los permisos
        rolePermissionDTO.getPermissions().stream()
                .map(permissionRepository::findByNombre)
                .filter(Objects::nonNull)
                .filter(permission -> rolePermissionEntityList.stream()
                        .noneMatch(rolePermissionEntity -> rolePermissionEntity.getPermiso().equals(permission)))
                .forEach(permission -> rolePermissionRepository.save(new RolePermissionEntity(roleEntity, permission)));

    }


    // Devuelve una lista de las IDs del rol y permiso
    public List<RolPermisoDTO> getRolPermiso() {
        List<RolPermisoDTO> rolPermisoDTOList = new ArrayList<>();

        // Itera a través de las relaciones RolePermissionEntity
        for (RolePermissionEntity rolePermissionEntity : rolePermissionRepository.findAll()) {
            RolPermisoDTO rolPermisoDTO = new RolPermisoDTO();

            // Establece los IDs de Rol y Permiso en el DTO
            rolPermisoDTO.setIdRol(rolePermissionEntity.getRol().getId());
            rolPermisoDTO.setIdPermiso(rolePermissionEntity.getPermiso().getId());

            rolPermisoDTOList.add(rolPermisoDTO);
        }

        return rolPermisoDTOList;
    }

}
