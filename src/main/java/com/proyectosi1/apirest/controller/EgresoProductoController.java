package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.entity.EgresoProductoEntity;
import com.proyectosi1.apirest.service.EgresoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/egreso_producto")
@RequiredArgsConstructor
public class EgresoProductoController {

    private final EgresoProductoService egreso_ProductoService;

    @PostMapping
    public EgresoProductoEntity createEgresoProducto(@RequestBody EgresoProductoEntity egreso_Producto) {
        return egreso_ProductoService.createEgreso_Producto(egreso_Producto);
    }

    @GetMapping
    public List<EgresoProductoEntity> getAllNotaEgreso() {
        return egreso_ProductoService.getAllEgreso_Productos();
    }

}

