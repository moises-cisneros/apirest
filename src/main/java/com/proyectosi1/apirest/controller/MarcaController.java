package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.model.dto.EnvioMarcaDTO;
import com.proyectosi1.apirest.model.entity.MarcaEntity;
import com.proyectosi1.apirest.service.MarcaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaEntity createMarca(@RequestBody MarcaEntity marca){
        return marcaService.createMarca(marca);
    }

    @PutMapping("/{id}")
    public MarcaEntity updateMarca(@PathVariable Integer id, @RequestBody MarcaEntity color) {
        color.setId(id);
        return marcaService.updateMarca(color);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Integer id) {
        marcaService.deleteMarca(id);
    }

    @GetMapping("/{id}")
    public MarcaEntity getMarca(@PathVariable Integer id) {
        return marcaService.getMarca(id);
    }

    @GetMapping
    public List<MarcaEntity> getAllMarcas() {
        return marcaService.getAllMarca();
    }


    @GetMapping("/send-marca")
    public EnvioMarcaDTO sendMarca(){
        return marcaService.sendMarca();
    } 

}
