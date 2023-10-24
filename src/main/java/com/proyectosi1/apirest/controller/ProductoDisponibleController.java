package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.ProductoDisponibleEntity;
import com.proyectosi1.apirest.service.ProductoDisponibleService;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ProductoDisponible")
@RequiredArgsConstructor
public class ProductoDisponibleController {
    private final ProductoDisponibleService productoDisponibleService;

    @PostMapping
    public ProductoDisponibleEntity crearProductoDisponible(@RequestBody ProductoDisponibleEntity productoDisponible) {
        return productoDisponibleService.crearProductoDisponible(productoDisponible);
    }

    @PutMapping("/{id}")
    public ProductoDisponibleEntity updateProductoDisponible(@PathVariable Integer id, @RequestBody ProductoDisponibleEntity productoDisponible) {
        productoDisponible.setId(id);
        return productoDisponibleService.updateProductoDisponible(productoDisponible);
    }

    @DeleteMapping("/{id}")
    public void deleteProductoDisponible(@PathVariable Integer id) {
        productoDisponibleService.deleteProductoDisponible(id);
    }

    @GetMapping("/{id}")
    public ProductoDisponibleEntity getProductoDisponible(@PathVariable Integer id) {
        return productoDisponibleService.getProductoDisponible(id);
    }

    @GetMapping
    public List<ProductoDisponibleEntity> getAllProductoDisponible() {
        return productoDisponibleService.getAllProductoDisponible();
    }

}
