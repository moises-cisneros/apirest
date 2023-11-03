package com.proyectosi1.apirest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.NotaVentaEntity;
import com.proyectosi1.apirest.service.NotaVentaService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notaventa")
public class NotaVentaController {
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

}
