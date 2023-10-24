package com.proyectosi1.apirest.auth;

import com.proyectosi1.apirest.auth.jwt.JwtService;
import com.proyectosi1.apirest.entity.UserEntity;
import com.proyectosi1.apirest.repository.UserRepository;
import com.proyectosi1.apirest.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        // Crear un nuevo objeto de usuario utilizando los datos proporcionados en el registro.
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())) // Codificar la contraseña antes de almacenarla.
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .role(Role.CLIENTE) // Codificar la contraseña antes de almacenarla.
                .build();

        // Guardar el nuevo usuario en el repositorio (almacenar en la base de datos).
        userRepository.save(user);

        // Generar un token de autenticacion para el usuario registrado y devolverlo en una respuesta.
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
