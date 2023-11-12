package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.RolPermisoDTO;
import com.proyectosi1.apirest.model.dto.RolePermissionDTO;
import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRole(@PathVariable Integer id, @RequestBody RoleEntity role) {
        role.setId(id);
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
    }

    @GetMapping("/{id}")
    public RoleEntity getRole(@PathVariable Integer id) {
        return roleService.getRole(id);
    }

    @GetMapping
    public List<RoleEntity> getAllRole() {
        return roleService.getAllRole();
    }

    @PostMapping("/add-permission")
    public void addListPermissions (@RequestBody RolePermissionDTO rolePermissionDTO) {
        roleService.addListPermissions(rolePermissionDTO);
    }

    @GetMapping("/permission")
    public List<RolPermisoDTO> getRolPermiso() {
        return roleService.getRolPermiso();
    }
}
