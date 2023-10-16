package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.BodegaEntity;
import com.proyectosi1.apirest.service.BodegaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bodega")
@RequiredArgsConstructor
public class BodegaController {
    private final BodegaService bodegaService;

    @PostMapping
    public BodegaEntity crearBodega(@RequestBody BodegaEntity  bodega) {
        return bodegaService.crearBodega(bodega);
    }
}
