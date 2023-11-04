package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.InventarioEntity;
import com.proyectosi1.apirest.model.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioService {
    private final InventarioRepository inventarioRepository;

    public InventarioEntity crearInventario(InventarioEntity productoDisponible) {
        return inventarioRepository.save(productoDisponible);
    }

    public InventarioEntity updateInventario(InventarioEntity productoDisponible) {
        return inventarioRepository.save((productoDisponible));
    }

    public void deleteInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }

    public InventarioEntity getInventario(Integer id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public List<InventarioEntity> getAllInventario() {
        return inventarioRepository.findAll();
    }

}
