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

    public void deleteEgreso_Producto(Integer id) {
        egreso_ProductoRepository.deleteById(id);
    }

    public EgresoProductoEntity getEgreso_Producto(Integer id) {
        return egreso_ProductoRepository.findById(id).orElse(null);
    }

    public List<EgresoProductoEntity> getAllEgreso_Productos() {
        return egreso_ProductoRepository.findAll();
    }

}
