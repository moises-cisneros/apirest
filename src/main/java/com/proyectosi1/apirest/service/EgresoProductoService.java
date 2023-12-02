package com.proyectosi1.apirest.service;

import java.util.List;

import com.proyectosi1.apirest.model.entity.EgresoProductoEntity;
import com.proyectosi1.apirest.model.repository.EgresoProductoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EgresoProductoService {
    private final EgresoProductoRepository egreso_ProductoRepository;

    public EgresoProductoEntity createEgreso_Producto(EgresoProductoEntity egreso_Producto){
        return egreso_ProductoRepository.save(egreso_Producto);
    }

    // Actualiza un registro de Egreso_Producto en la base de datos
    public EgresoProductoEntity updateEgreso_Producto(EgresoProductoEntity egreso_Producto) {
        return egreso_ProductoRepository.save((egreso_Producto));
    }

    public List<EgresoProductoEntity> getAllEgreso_Productos() {
        return egreso_ProductoRepository.findAll();
    }

}
