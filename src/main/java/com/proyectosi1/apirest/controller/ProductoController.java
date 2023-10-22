package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.ProductoEntity;
import com.proyectosi1.apirest.service.ProductoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping
    public ProductoEntity crearProducto(@RequestBody ProductoEntity producto) {
        producto.getColor().getId();
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}") 
    public ProductoEntity updateProducto(@PathVariable Integer id, @RequestBody ProductoEntity producto) {
        producto.setId(id);
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }

    @GetMapping("/{id}")
    public ProductoEntity getProducto(@PathVariable Integer id) {
        return productoService.getProducto(id);
    }

    @GetMapping
    public List<ProductoEntity> getAllProducto() {
        return productoService.getAllProducto();
    }

}
