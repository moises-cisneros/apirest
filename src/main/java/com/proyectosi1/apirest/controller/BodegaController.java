package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.entity.BodegaEntity;
import com.proyectosi1.apirest.service.BodegaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/bodega")
@RequiredArgsConstructor
public class BodegaController {
    private final BodegaService bodegaService;

    @PostMapping
    public BodegaEntity createBodega(@RequestBody BodegaEntity  bodega) {
        return bodegaService.createBodega(bodega);
    }

    @PutMapping("/{id}")
    public BodegaEntity updateBodega(@PathVariable Integer id, @RequestBody BodegaEntity bodega) {
        bodega.setId(id);
        return bodegaService.updateBodega(bodega);
    }

    @DeleteMapping("/{id}")
    public void deletBodega(@PathVariable Integer id) {
        bodegaService.deleteBodega(id);
    }

    @GetMapping("/{id}")
    public BodegaEntity getBodega(@PathVariable Integer id) {
        return bodegaService.getBodega(id);
    }

    @GetMapping
    public List<BodegaEntity> getAllBodegas() {
        return bodegaService.getAllBodegas();
    }
}
