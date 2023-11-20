package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.entity.RolePermissionEntity;
import com.proyectosi1.apirest.model.mapper.PermissionMapper;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.model.repository.RolePermissionRepository;
import com.proyectosi1.apirest.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PermissionService {
    @Autowired
    private final PermissionRepository permissionRepository;
    @Autowired
    private final PermissionMapper permissionMapper;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RolePermissionRepository rolePermissionRepository;

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

    public List<String> userPermissionList(String username) {
        List<String> permissionList = new ArrayList<>();
        List<PermissionEntity> permissionEntityList = permissionRepository.findAll();

        int idRol = userRepository.findByUsername(username).get().getRole().getId();

        List<RolePermissionEntity> rolePermissionEntityList = (List<RolePermissionEntity>) rolePermissionRepository.findByPermiso(idRol);

        for (RolePermissionEntity rolePermission : rolePermissionEntityList) {
            PermissionEntity permission = permissionRepository.findById(rolePermission.getPermiso().getId()).orElse(null);

            if (permissionEntityList.contains(permission)) {
                permissionList.add(permission.getNombre());
            }

        }

        return permissionList;
    }

}
