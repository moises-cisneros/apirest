package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.entity.NotaEgresoEntity;
import com.proyectosi1.apirest.service.NotaEgresoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_egreso")
@RequiredArgsConstructor
public class NotaEgresoController {
    private final NotaEgresoService nota_EgresoService;
    
    @PostMapping
    public NotaEgresoEntity createNota_Egreso(@RequestBody NotaEgresoEntity nota_Egreso) {
        return nota_EgresoService.createNota_Egreso(nota_Egreso);
    }

    @PutMapping("/{id}")
    public NotaEgresoEntity updateNota_Egreso(@PathVariable Integer id, @RequestBody NotaEgresoEntity nota_Egreso) {
        nota_Egreso.setId(id);
        return nota_EgresoService.updateNota_Egreso(nota_Egreso);
    }

    @DeleteMapping("/{id}")
    public void deleteNota_Egreso(@PathVariable Integer id) {
        nota_EgresoService.deleteNota_Egreso(id);
    }

    @GetMapping("/{id}")
    public NotaEgresoEntity getNota_Egreso(@PathVariable Integer id) {
        return nota_EgresoService.getNota_Egreso(id);
    }

    @GetMapping
    public List<NotaEgresoEntity> getAllNota_Egreso() {
        return nota_EgresoService.getAllNota_Egreso();
    }
}

