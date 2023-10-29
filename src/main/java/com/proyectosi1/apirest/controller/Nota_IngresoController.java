package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.entity.Nota_IngresoEntity;

import com.proyectosi1.apirest.service.Nota_IngresoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_ingreso")
@RequiredArgsConstructor
public class Nota_IngresoController {
    private final Nota_IngresoService nota_IngresoService;
    
    @PostMapping
    public Nota_IngresoEntity createNota_Ingreso(@RequestBody Nota_IngresoEntity nota_Ingreso) {
        return nota_IngresoService.createNota_Ingreso(nota_Ingreso);
    }

    @PutMapping("/{id}")
    public Nota_IngresoEntity updateNota_Ingreso(@PathVariable Integer id, @RequestBody Nota_IngresoEntity nota_Ingreso) {
        nota_Ingreso.setId(id);
        return nota_IngresoService.updateNota_Ingreso(nota_Ingreso);
    }

    @DeleteMapping("/{id}")
    public void deleteNota_Ingreso(@PathVariable Integer id) {
        nota_IngresoService.deleteNota_Ingreso(id);
    }

    @GetMapping("/{id}")
    public Nota_IngresoEntity getNota_Ingreso(@PathVariable Integer id) {
        return nota_IngresoService.getNota_Ingreso(id);
    }

    @GetMapping
    public List<Nota_IngresoEntity> getAllNota_Ingreso() {
        return nota_IngresoService.getAllNota_Ingreso();
    }
}

