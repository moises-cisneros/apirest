package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.service.IngresoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingreso_producto")
@RequiredArgsConstructor
public class Ingreso_ProductoController {
    private final IngresoProductoService ingreso_ProductoService;
    /*
    @PostMapping
    public IngresoProductoEntity createIngreso_Producto(@RequestBody IngresoProductoEntity ingreso_Producto) {
        return ingreso_ProductoService.createIngreso_Producto(ingreso_Producto);
    }

    @PutMapping("/{id}")
    public IngresoProductoEntity updateIngreso_Producto(@PathVariable Integer id, @RequestBody IngresoProductoEntity ingreso_Producto) {
        ingreso_Producto.setId(id);
        return ingreso_ProductoService.updateIngreso_Producto(ingreso_Producto);
    }

    @DeleteMapping("/{id}")
    public void deleteIngreso_Producto(@PathVariable Integer id) {
        ingreso_ProductoService.deleteIngreso_Producto(id);
    }

    @GetMapping("/{id}")
    public IngresoProductoEntity getIngreso_Producto(@PathVariable Integer id) {
        return ingreso_ProductoService.getIngreso_Producto(id);
    }

    @GetMapping
    public List<IngresoProductoEntity> getAllIngreso_Producto() {
        return ingreso_ProductoService.getAllIngreso_Productos();
    }*/
}

