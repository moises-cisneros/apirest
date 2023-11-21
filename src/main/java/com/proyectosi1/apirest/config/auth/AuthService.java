package com.proyectosi1.apirest.config.auth;

import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.entity.RolePermissionEntity;
import com.proyectosi1.apirest.model.repository.RolePermissionRepository;
import com.proyectosi1.apirest.service.RoleService;
import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.model.repository.UserRepository;
import com.proyectosi1.apirest.config.jwt.JwtService;
import com.proyectosi1.apirest.model.dto.NamePermisosDTO;
import com.proyectosi1.apirest.model.entity.PermissionEntity;
import com.proyectosi1.apirest.model.repository.PermissionRepository;
import com.proyectosi1.apirest.utils.Permission;
import com.proyectosi1.apirest.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private static RoleEntity userRegister;
    private final RoleService roleService;
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;

    public AuthResponse register(RegisterRequest request) {

        // Agregar permisos
        addPermissions();

        // Asignar el rol automaticamente
        autoAssignRole();

        // Crear un nuevo objeto de usuario utilizando los datos proporcionados en el registro.
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())) // Codificar la contraseña antes de almacenarla.
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .role(userRegister)
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
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    // Iterar sobre la lista de nombres de permisos y guardarlos en el repositorio
    private void addPermissions() {
        if (permissionRepository.count() == 0) {
            for (String namePermissions : Permission.getAllPermissionNames()) {
                permissionRepository.save(PermissionEntity.builder().nombre(namePermissions).build());
            }
        }
    }

    private void autoAssignRole() {
        if (userRepository.count() == 0) {
            userRegister = RoleEntity.builder().id(1).name(Role.ADMIN.name()).build();

            loadRoles();
            autoAssignPermissions();

        } else {
            userRegister = RoleEntity.builder().id(2).name(Role.CLIENTE.name()).build();
        }
    }

    private void loadRoles() {
        roleService.createRole(RoleEntity.builder().id(1).name(Role.ADMIN.name()).build());
        roleService.createRole(RoleEntity.builder().id(2).name(Role.CLIENTE.name()).build());
    }

    private void autoAssignPermissions() {
        for (PermissionEntity permission : permissionRepository.findAll()) {
            rolePermissionRepository.save(RolePermissionEntity
                    .builder()
                    .rol(RoleEntity.builder().id(1).build())
                    .permiso(permission)
                    .build());
        }
    }

}
