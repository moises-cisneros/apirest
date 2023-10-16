package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.entity.UserEntity;
import com.proyectosi1.apirest.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public UserEntity actualizarUsuario(@PathVariable long id, @RequestBody UserEntity usuario) {
        usuario.setId(id);
        return userService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable long id) {
        userService.eliminarUsuario(id);
    }

    @GetMapping("/{id}")
    public UserEntity obtenerUsuarioPorId(@PathVariable long id) {
        return userService.obtenerUsuarioPorId(id);
    }

    @GetMapping
    public List<UserEntity> obtenerTodosLosUsuarios() {
        return userService.obtenerTodosLosUsuarios();
    }
}
