package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.service.PermissionService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public PermissionEntity createPermission(@RequestBody PermissionEntity permission) {
        return permissionService.createPermission(permission);
    }

    @PutMapping("/{id}")
    public PermissionEntity updatePermission(@PathVariable Integer id, @RequestBody PermissionEntity permission) {
        permission.setId(id);
        return permissionService.updatePermission(permission);
    }

    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Integer id) {
        permissionService.deletePermission(id);
    }

    @GetMapping("/{id}")
    public PermissionEntity getPermission(@PathVariable Integer id) {
        return permissionService.getPermission(id);
    }

    @GetMapping
    public List<PermissionEntity> getAllPermission() {
        return permissionService.getAllPermission();
    }

    @GetMapping("/list-permissions")
    public List<String> userPermissionList(@RequestParam String username) {
        return permissionService.userPermissionList(username);
    }

}
