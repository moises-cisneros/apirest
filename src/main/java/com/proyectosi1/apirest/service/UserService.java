package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //public List<>




}
