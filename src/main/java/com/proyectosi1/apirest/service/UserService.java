package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.entity.UserEntity;
import com.proyectosi1.apirest.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity crearUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    public UserEntity actualizarUsuario(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    public void eliminarUsuario(long id) {
        userRepository.deleteById(id);
    }

    public UserEntity obtenerUsuarioPorId(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }
}
