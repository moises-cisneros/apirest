package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.BodegaDTO;
import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.service.BodegaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/bodega")
@RequiredArgsConstructor
public class BodegaController {
    private final BodegaService bodegaService;

    @PostMapping
    public BodegaDTO createBodega(@RequestBody BodegaDTO  bodega) {
        return bodegaService.createBodega(bodega);
    }

    @PutMapping("/{id}")
    public BodegaDTO updateBodega(@PathVariable Integer id, @RequestBody BodegaDTO bodega) {
        bodega.setId(id);
        return bodegaService.updateBodega(bodega);
    }

    @DeleteMapping("/{id}")
    public void deletBodega(@PathVariable Integer id) {
        bodegaService.deleteBodega(id);
    }

    @GetMapping("/{id}")
    public BodegaDTO getBodega(@PathVariable Integer id) {
        return bodegaService.getBodega(id);
    }

    @GetMapping
    public List<BodegaDTO> getAllBodegas() {
        return bodegaService.getAllBodegas();
    }
}
