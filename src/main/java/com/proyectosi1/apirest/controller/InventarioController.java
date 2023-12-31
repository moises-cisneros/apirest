package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.model.entity.InventarioEntity;
import com.proyectosi1.apirest.service.InventarioService;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioService inventarioService;

    @PostMapping
    public InventarioEntity crearInventario(@RequestBody InventarioEntity inventario) {
        return inventarioService.crearInventario(inventario);
    }

    @PutMapping("/{id}")
    public InventarioEntity updateInventario(@PathVariable Integer id, @RequestBody InventarioEntity inventario) {
        inventario.setId(id);
        return inventarioService.updateInventario(inventario);
    }

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Integer id) {
        inventarioService.deleteInventario(id);
    }

    @GetMapping("/{id}")
    public InventarioEntity getInventario(@PathVariable Integer id) {
        return inventarioService.getInventario(id);
    }

    @GetMapping
    public List<InventarioEntity> getAllInventario() {
        return inventarioService.getAllInventario();
    }

}
