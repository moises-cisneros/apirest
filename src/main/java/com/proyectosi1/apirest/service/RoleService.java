package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.RolPermisoDTO;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.mapper.RoleMapper;
import com.proyectosi1.apirest.model.dto.RolePermissionDTO;
import com.proyectosi1.apirest.model.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

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

    // Dado un rol, le agrega todos los permisos asignados
    public RoleEntity addListPermissions(RolePermissionDTO rolePermissionDTO) {
        return roleMapper.addListPermissions(rolePermissionDTO);
    }

    // Devuelve una lista de las IDs del rol y permiso
    public List<RolPermisoDTO> getRolPermiso() {
        return roleMapper.getRolPermiso();
    }
}
