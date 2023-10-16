package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.MarcaEntity;
import com.proyectosi1.apirest.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaEntity crearMarca(MarcaEntity marca) {
        return marcaRepository.save(marca);
    }

}
