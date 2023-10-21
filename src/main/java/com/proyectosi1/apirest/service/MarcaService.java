package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.entity.ColorEntity;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.MarcaEntity;
import com.proyectosi1.apirest.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaEntity crearMarca(MarcaEntity marca) {
        return marcaRepository.save(marca);
    }

    // Actualiza un registro de color en la base de datos
    public MarcaEntity updateMarca(MarcaEntity marca) {
        return marcaRepository.save((marca));
    }

    public void deleteMarca(Integer id) {
        marcaRepository.deleteById(id);
    }

    public MarcaEntity getMarca(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public List<MarcaEntity> getAllMarca() {
        return marcaRepository.findAll();
    }
}
