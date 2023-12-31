package com.proyectosi1.apirest.config.auth;

import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    // Endpoint de registro de usuario
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    // Endpoint de login de usuario
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
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

}
