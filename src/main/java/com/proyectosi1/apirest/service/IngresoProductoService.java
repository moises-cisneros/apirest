package com.proyectosi1.apirest.service;

import java.util.List;

import com.proyectosi1.apirest.model.entity.IngresoProductoEntity;
import com.proyectosi1.apirest.model.repository.IngresoProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IngresoProductoService {
    private final IngresoProductoRepository ingresoProductoRepository;

    public IngresoProductoEntity createIngresoProducto(IngresoProductoEntity ingreso_Producto) {
        return ingresoProductoRepository.save(ingreso_Producto);
    }

    // Actualiza un registro de IngresoProducto en la base de datos
    public IngresoProductoEntity updateIngresoProducto(IngresoProductoEntity ingreso_Producto) {
        return ingresoProductoRepository.save((ingreso_Producto));
    }

    public List<IngresoProductoEntity> getAllIngresoProductos() {
        return ingresoProductoRepository.findAll();
    }

    @Transactional
    public void crearTriggerEnProducto() {
        ingresoProductoRepository.crearTrigger();
    }

}