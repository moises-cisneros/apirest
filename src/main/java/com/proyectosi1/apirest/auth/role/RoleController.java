package com.proyectosi1.apirest.auth.role;

import com.proyectosi1.apirest.dto.RolePermissionDTO;
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
    public RoleEntity addListPermisos (@RequestBody RolePermissionDTO rolePermissionDTO) {
        return roleService.addListPermisos(rolePermissionDTO);
    }
}
