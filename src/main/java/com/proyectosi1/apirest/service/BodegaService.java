package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.BodegaEntity;
import com.proyectosi1.apirest.repository.BodegaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BodegaService {
    private final BodegaRepository bodegaRepository;

    public BodegaEntity crearBodega(BodegaEntity bodega) {
        return bodegaRepository.save(bodega); 
    }


}
