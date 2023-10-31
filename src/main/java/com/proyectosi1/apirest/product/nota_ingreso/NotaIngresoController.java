package com.proyectosi1.apirest.product.nota_ingreso;

import com.proyectosi1.apirest.dto.NotaIngresoDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_ingreso")
@RequiredArgsConstructor
public class NotaIngresoController {
    private final NotaIngresoService notaIngresoService;

    /*
    @PostMapping
    public NotaIngresoEntity createNotaIngreso(@RequestBody NotaIngresoEntity nota_Ingreso) {
        return notaIngresoService.createNotaIngreso(nota_Ingreso);
    }
     */

    @PutMapping("/{id}")
    public NotaIngresoEntity updateNotaIngreso(@PathVariable Integer id, @RequestBody NotaIngresoEntity nota_Ingreso) {
        nota_Ingreso.setId(id);
        return notaIngresoService.updateNotaIngreso(nota_Ingreso);
    }

    @DeleteMapping("/{id}")
    public void deleteNotaIngreso(@PathVariable Integer id) {
        notaIngresoService.deleteNotaIngreso(id);
    }

    @GetMapping("/{id}")
    public NotaIngresoEntity getNotaIngreso(@PathVariable Integer id) {
        return notaIngresoService.getNotaIngreso(id);
    }

    @GetMapping
    public List<NotaIngresoEntity> getAllNotaIngreso() {
        return notaIngresoService.getAllNotaIngreso();
    }

    @PostMapping
    public void createNotaIngreso (@RequestBody NotaIngresoDTO notaIngreso) {
        notaIngresoService.createNotaIngreso(notaIngreso);
    }
}

