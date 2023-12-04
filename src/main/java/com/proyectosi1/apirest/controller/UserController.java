package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity crearUsuario(@RequestBody UserEntity usuario) {
        return userService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public UserEntity actualizarUsuario(@PathVariable Integer id, @RequestBody UserEntity usuario) {
        usuario.setId(id);
        return userService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        userService.eliminarUsuario(id);
    }

    @GetMapping("/{id}")
    public UserEntity obtenerUsuarioPorId(@PathVariable Integer id) {
        return userService.obtenerUsuarioPorId(id);
    }

    @GetMapping
    public List<UserEntity> obtenerTodosLosUsuarios() {
        return userService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/get-role")
    public String getRole(@RequestParam String username) {
        UserEntity user = userService.obtenerUsuarioPorUsername(username);
        if (user != null) {
            return user.getRole().getName();
        } else {
            return "Usuario no encontrado";
        }
    }

    @PutMapping("/new-password")
    public void changePassword(@RequestParam Integer id, @RequestParam String newPassword) {
        userService.changePassword(id, newPassword);
    }
    
    @GetMapping("/perfilUser")
    public UserEntity getUserData(@RequestParam String username){
        return userService.obtenerUsuarioPorUsername(username);
    }

}
