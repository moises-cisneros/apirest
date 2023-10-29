package com.proyectosi1.apirest.auth;

import com.proyectosi1.apirest.auth.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
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

    /*
    // Obtener el rol del usuario
    @PostMapping("/getRole")
    public Role getRole(@RequestParam String username) {
        UserEntity user = userService.obtenerUsuarioPorUsername(username);
        if (user != null) {
            return user.getRole();
        } else {
            return Role.ADMIN;
        }
    }

    @GetMapping("/roleGet")
    public Role roleGet(@RequestParam String username) {
        UserEntity user = userService.obtenerUsuarioPorUsername(username);
        if (user != null) {
            return user.getRole();
        } else {
            return Role.ADMIN;
        }
    }*/
}
