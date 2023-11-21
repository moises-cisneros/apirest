package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.MarcaDTO;
import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.service.MarcaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaDTO createMarca(@RequestBody MarcaDTO marca){
        return marcaService.createMarca(marca);
    }

    @PutMapping("/{id}")
    public MarcaDTO updateMarca(@PathVariable Integer id, @RequestBody MarcaDTO color) {
        color.setId(id);
        return marcaService.updateMarca(color);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Integer id) {
        marcaService.deleteMarca(id);
    }

    @GetMapping("/{id}")
    public MarcaDTO getMarca(@PathVariable Integer id) {
        return marcaService.getMarca(id);
    }

    @GetMapping
    public List<MarcaDTO> getAllMarca() {
        return marcaService.getAllMarca();
    }

}
