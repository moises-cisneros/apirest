package com.proyectosi1.apirest.controller;

import java.util.List;

import com.proyectosi1.apirest.model.dto.EstadoVentaDTO;
import com.proyectosi1.apirest.model.dto.NotaVentaDTO;
import com.proyectosi1.apirest.model.dto.UpdateEstadoDTO;
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

    @GetMapping("/all-sales-note")
    public List<NotaVentaDTO> getAllSalesNote() {
        return notaVentaService.getAllSalesNote();
    }

    @GetMapping("/report-sales-note")
    public ResponseEntity<Resource> exportSalesNoteReport(@RequestParam Integer idNotaVenta) {
        return notaVentaService.exportReportNoteSale(idNotaVenta);
    }

    @GetMapping("/total-quantity")
    public Integer totalQuantityItemsSalesNote() {
        return notaVentaService.totalQuantityItemsSalesNote();
    }

    @GetMapping("/estado-venta")
    public List<EstadoVentaDTO> estadoVenta(){
        return notaVentaService.estadoVenta();
    }

    @PostMapping("/update-estado")
    public void updateEstado(@RequestBody UpdateEstadoDTO nuevoEstado) {
        notaVentaService.updateEstado(nuevoEstado);
    }

}
