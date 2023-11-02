package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.BodegaEntity;
import com.proyectosi1.apirest.repository.BodegaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BodegaService {
    private final BodegaRepository bodegaRepository;

    public BodegaEntity createBodega(BodegaEntity bodega) {
        return bodegaRepository.save(bodega); 
    }

    // Actualiza un registro de color en la base de datos
    public BodegaEntity updateBodega(BodegaEntity bodega) {
        return bodegaRepository.save((bodega));
    }

    public void deleteBodega(Integer id) {
        bodegaRepository.deleteById(id);
    }

    public BodegaEntity getBodega(Integer id) {
        return bodegaRepository.findById(id).orElse(null);
    }

    public List<BodegaEntity> getAllBodegas() {
        return bodegaRepository.findAll();
    }

}
