package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.ProductoDisponibleEntity;
import com.proyectosi1.apirest.repository.ProductoDisponibleRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoDisponibleService {
    private final ProductoDisponibleRepository productoDisponibleRepository;

    public ProductoDisponibleEntity crearProductoDisponible(ProductoDisponibleEntity productoDisponible) {
        return productoDisponibleRepository.save(productoDisponible);
    }

    public ProductoDisponibleEntity updateProductoDisponible(ProductoDisponibleEntity productoDisponible) {
        return productoDisponibleRepository.save((productoDisponible));
    }

    public void deleteProductoDisponible(Integer id) {
        productoDisponibleRepository.deleteById(id);
    }

    public ProductoDisponibleEntity getProductoDisponible(Integer id) {
        return productoDisponibleRepository.findById(id).orElse(null);
    }

    public List<ProductoDisponibleEntity> getAllProductoDisponible() {
        return productoDisponibleRepository.findAll();
    }

}
