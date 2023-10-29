package com.proyectosi1.apirest.product.nota_ingreso;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_ingreso")
@RequiredArgsConstructor
public class Nota_IngresoController {
    private final NotaIngresoService nota_IngresoService;
    
    @PostMapping
    public NotaIngresoEntity createNota_Ingreso(@RequestBody NotaIngresoEntity nota_Ingreso) {
        return nota_IngresoService.createNota_Ingreso(nota_Ingreso);
    }

    @PutMapping("/{id}")
    public NotaIngresoEntity updateNota_Ingreso(@PathVariable Integer id, @RequestBody NotaIngresoEntity nota_Ingreso) {
        nota_Ingreso.setId(id);
        return nota_IngresoService.updateNota_Ingreso(nota_Ingreso);
    }

    @DeleteMapping("/{id}")
    public void deleteNota_Ingreso(@PathVariable Integer id) {
        nota_IngresoService.deleteNota_Ingreso(id);
    }

    @GetMapping("/{id}")
    public NotaIngresoEntity getNota_Ingreso(@PathVariable Integer id) {
        return nota_IngresoService.getNota_Ingreso(id);
    }

    @GetMapping
    public List<NotaIngresoEntity> getAllNota_Ingreso() {
        return nota_IngresoService.getAllNota_Ingreso();
    }
}

