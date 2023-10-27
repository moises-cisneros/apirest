package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.entity.Ingreso_ProductoEntity;

import com.proyectosi1.apirest.service.Ingreso_ProductoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingreso_producto")
@RequiredArgsConstructor
public class Ingreso_ProductoController {
    private final Ingreso_ProductoService ingreso_ProductoService;
    
    @PostMapping
    public Ingreso_ProductoEntity createIngreso_Producto(@RequestBody Ingreso_ProductoEntity ingreso_Producto) {
        return ingreso_ProductoService.createIngreso_Producto(ingreso_Producto);
    }

    @PutMapping("/{id}")
    public Ingreso_ProductoEntity updateIngreso_Producto(@PathVariable Integer id, @RequestBody Ingreso_ProductoEntity ingreso_Producto) {
        ingreso_Producto.setId(id);
        return ingreso_ProductoService.updateIngreso_Producto(ingreso_Producto);
    }

    @DeleteMapping("/{id}")
    public void deleteIngreso_Producto(@PathVariable Integer id) {
        ingreso_ProductoService.deleteIngreso_Producto(id);
    }

    @GetMapping("/{id}")
    public Ingreso_ProductoEntity getIngreso_Producto(@PathVariable Integer id) {
        return ingreso_ProductoService.getIngreso_Producto(id);
    }

    @GetMapping
    public List<Ingreso_ProductoEntity> getAllIngreso_Producto() {
        return ingreso_ProductoService.getAllIngreso_Productos();
    }
}

