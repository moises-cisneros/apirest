package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.entity.MarcaEntity;
import com.proyectosi1.apirest.service.MarcaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaEntity crearMarca(@RequestBody MarcaEntity marca){
        return marcaService.crearMarca(marca);
    }

    @PutMapping("/{id}")
    public MarcaEntity updateColor(@PathVariable Integer id, @RequestBody MarcaEntity color) {
        color.setId(id);
        return marcaService.updateMarca(color);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Integer id) {
        marcaService.deleteMarca(id);
    }

    @GetMapping("/{id}")
    public MarcaEntity getColor(@PathVariable Integer id) {
        return marcaService.getMarca(id);
    }

    @GetMapping
    public List<MarcaEntity> getAllColors() {
        return marcaService.getAllMarca();
    }
}
