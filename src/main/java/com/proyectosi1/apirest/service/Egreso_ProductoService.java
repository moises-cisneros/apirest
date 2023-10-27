package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.Egreso_ProductoEntity;
import com.proyectosi1.apirest.repository.Egreso_ProductoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Egreso_ProductoService {
    private final Egreso_ProductoRepository egreso_ProductoRepository;

    public Egreso_ProductoEntity createEgreso_Producto(Egreso_ProductoEntity egreso_Producto){
        return egreso_ProductoRepository.save(egreso_Producto);
    }

    // Actualiza un registro de Egreso_Producto en la base de datos
    public Egreso_ProductoEntity updateEgreso_Producto(Egreso_ProductoEntity egreso_Producto) {
        return egreso_ProductoRepository.save((egreso_Producto));
    }

    public void deleteEgreso_Producto(Integer id) {
        egreso_ProductoRepository.deleteById(id);
    }

    public Egreso_ProductoEntity getEgreso_Producto(Integer id) {
        return egreso_ProductoRepository.findById(id).orElse(null);
    }

    public List<Egreso_ProductoEntity> getAllEgreso_Productos() {
        return egreso_ProductoRepository.findAll();
    }

}
