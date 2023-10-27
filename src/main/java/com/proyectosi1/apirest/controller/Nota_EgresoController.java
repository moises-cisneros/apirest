package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.entity.Nota_EgresoEntity;

import com.proyectosi1.apirest.service.Nota_EgresoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_egreso")
@RequiredArgsConstructor
public class Nota_EgresoController {
    private final Nota_EgresoService nota_EgresoService;
    
    @PostMapping
    public Nota_EgresoEntity createNota_Egreso(@RequestBody Nota_EgresoEntity nota_Egreso) {
        return nota_EgresoService.createNota_Egreso(nota_Egreso);
    }

    @PutMapping("/{id}")
    public Nota_EgresoEntity updateNota_Egreso(@PathVariable Integer id, @RequestBody Nota_EgresoEntity nota_Egreso) {
        nota_Egreso.setId(id);
        return nota_EgresoService.updateNota_Egreso(nota_Egreso);
    }

    @DeleteMapping("/{id}")
    public void deleteNota_Egreso(@PathVariable Integer id) {
        nota_EgresoService.deleteNota_Egreso(id);
    }

    @GetMapping("/{id}")
    public Nota_EgresoEntity getNota_Egreso(@PathVariable Integer id) {
        return nota_EgresoService.getNota_Egreso(id);
    }

    @GetMapping
    public List<Nota_EgresoEntity> getAllNota_Egreso() {
        return nota_EgresoService.getAllNota_Egreso();
    }
}

