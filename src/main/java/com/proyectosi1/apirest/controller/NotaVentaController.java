package com.proyectosi1.apirest.controller;

import java.util.List;
import java.util.Optional;

import com.proyectosi1.apirest.model.dto.NotaVentaClienteDTO;
import com.proyectosi1.apirest.model.dto.ReporteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.service.NotaVentaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notaventa")
public class NotaVentaController {
    @Autowired
    private final NotaVentaService notaVentaService;

    @PostMapping
    public NotaVentaEntity crearNotaVenta(@RequestBody NotaVentaEntity notaVentaEntity) {
        return notaVentaService.crearNotaVenta(notaVentaEntity);
    }

    @PutMapping
    public NotaVentaEntity updateNotaVenta(@RequestBody NotaVentaEntity notaVentaEntity) {
        return notaVentaService.updateNotaventa(notaVentaEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteNotaVenta(@PathVariable Integer id) {
        notaVentaService.deleteNotaVenta(id);
    }

    @GetMapping("/{id}")
    public NotaVentaEntity getNotaVenta(@PathVariable Integer id) {
        return notaVentaService.getNotaVenta(id);
    }

    @GetMapping
    public List<NotaVentaEntity> getAllNotaVenta() {
        return notaVentaService.getAllNotaVenta();
    }

    @GetMapping("/report-sales-note")
    public ResponseEntity<Resource> exportSalesNoteReport(@RequestParam Integer idNotaVenta) {
        return notaVentaService.exportSalesNoteReport(idNotaVenta);
    }

    // Metodo de prueba
    @GetMapping("/prueba")
    public NotaVentaClienteDTO prueba(@RequestParam Integer idNotaVenta) {
        return notaVentaService.prueba(idNotaVenta);
    }

    @GetMapping("/prueba2")
    public Iterable<ReporteDTO> prueba2(@RequestParam Integer idNotaVenta) {
        return notaVentaService.parametersDTO(idNotaVenta);
    }


}
