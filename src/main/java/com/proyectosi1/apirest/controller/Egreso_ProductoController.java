package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.service.EgresoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/egreso_producto")
@RequiredArgsConstructor
public class Egreso_ProductoController {
    private final EgresoProductoService egreso_ProductoService;

    /*
    @PostMapping
    public EgresoProductoEntity createCategory(@RequestBody EgresoProductoEntity egreso_Producto) {
        return egreso_ProductoService.createEgreso_Producto(egreso_Producto);
    }

    @PutMapping("/{id}")
    public EgresoProductoEntity updateCategory(@PathVariable Integer id, @RequestBody EgresoProductoEntity egreso_Producto) {
        egreso_Producto.setId(id);
        return egreso_ProductoService.updateEgreso_Producto(egreso_Producto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        egreso_ProductoService.deleteEgreso_Producto(id);
    }

    @GetMapping("/{id}")
    public EgresoProductoEntity getCategory(@PathVariable Integer id) {
        return egreso_ProductoService.getEgreso_Producto(id);
    }

    @GetMapping
    public List<EgresoProductoEntity> getAllCategory() {
        return egreso_ProductoService.getAllEgreso_Productos();
    }*/
}

