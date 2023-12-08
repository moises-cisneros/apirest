package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.RoleEntity;
import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.model.repository.RoleRepository;
import com.proyectosi1.apirest.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity crearUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    public UserEntity actualizarUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        userRepository.deleteById(id);
    }

    public UserEntity obtenerUsuarioPorId(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }

    public String obtenerRolCliente(UserEntity user) {
        return user.getRole().equals("CLIENTE") ? "CLIENTE" : null;
    }

    public UserEntity obtenerUsuarioPorUsername(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    public void changePassword(Integer id, String newPassword) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return;
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void changeRole(Integer id, Integer idRole) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return;
        }

        RoleEntity role = roleRepository.findById(idRole).orElse(null);
        if (role == null) {
            return;
        }

        user.setRole(role);
        userRepository.save(user);
    }

}
