package com.proyectosi1.apirest.auth.user;

import com.proyectosi1.apirest.dto.GetRoleDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get-role")
    public GetRoleDTO getRole(@RequestBody String username) {
        return userService.getRole(username);
    }

    /*
    @PostMapping("/getRole")
    public Role getRole(@RequestParam String username) {
        UserEntity user = userService.obtenerUsuarioPorUsername(username);
        if (user != null) {
            return user.getRole();
        } else {
            return Role.ADMIN;
        }
    }*/

}
