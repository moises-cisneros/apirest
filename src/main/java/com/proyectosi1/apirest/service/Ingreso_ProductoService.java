package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.Ingreso_ProductoEntity;
import com.proyectosi1.apirest.repository.Ingreso_ProductoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Ingreso_ProductoService {
    private final Ingreso_ProductoRepository ingreso_ProductoRepository;

    public Ingreso_ProductoEntity createIngreso_Producto(Ingreso_ProductoEntity ingreso_Producto){
        return ingreso_ProductoRepository.save(ingreso_Producto);
    }

    // Actualiza un registro de Ingreso_Producto en la base de datos
    public Ingreso_ProductoEntity updateIngreso_Producto(Ingreso_ProductoEntity ingreso_Producto) {
        return ingreso_ProductoRepository.save((ingreso_Producto));
    }

    public void deleteIngreso_Producto(Integer id) {
        ingreso_ProductoRepository.deleteById(id);
    }

    public Ingreso_ProductoEntity getIngreso_Producto(Integer id) {
        return ingreso_ProductoRepository.findById(id).orElse(null);
    }

    public List<Ingreso_ProductoEntity> getAllIngreso_Productos() {
        return ingreso_ProductoRepository.findAll();
    }

}