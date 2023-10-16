package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.MarcaEntity;
import com.proyectosi1.apirest.service.MarcaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaEntity crearMarca(@RequestBody MarcaEntity marca){
        return marcaService.crearMarca(marca);
    }
}
