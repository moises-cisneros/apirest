package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import com.proyectosi1.apirest.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_venta")
@RequiredArgsConstructor
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    @PostMapping
    public DetalleVentaEntity createDetalleVenta(@RequestBody  DetalleVentaEntity detalleVentaEntity) {
        return detalleVentaService.createDetalleVenta(detalleVentaEntity);
    }

    @PutMapping("/{id}")
    public DetalleVentaEntity updateDetalleVenta(@PathVariable Integer id, @RequestBody DetalleVentaEntity detalleVentaEntity) {
        return detalleVentaService.updateDetalleVenta(id, detalleVentaEntity);
    }

    @GetMapping("/{id}")
    public DetalleVentaEntity getDetalleVenta(@PathVariable Integer id) {
        return detalleVentaService.getDetalleVenta(id);
    }

    public List<DetalleVentaEntity> getAllDetalleVenta() {
        return detalleVentaService.getAllDetalleVenta();
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleVenta(@PathVariable Integer id) {
        detalleVentaService.deleteDetalleVenta(id);
    }

}
