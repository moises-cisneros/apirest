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

import com.proyectosi1.apirest.model.entity.TipoPagoEntity;
import com.proyectosi1.apirest.service.TipoPagoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipopago")
public class TipoPagoController {
    private final TipoPagoService tipoPagoService;

    @PostMapping
    public TipoPagoEntity crearTipoPago(@RequestBody TipoPagoEntity tipoPagoEntity) {
        return tipoPagoService.createTipoPago(tipoPagoEntity);
    }

    @PutMapping
    public TipoPagoEntity updateTipoPago(@RequestBody TipoPagoEntity tipoPagoEntity) {
        return tipoPagoService.updateTipoPago(tipoPagoEntity);
    }

    @GetMapping("/{id}")
    public TipoPagoEntity getTipoPago(@PathVariable Integer id) {
        return tipoPagoService.getTipoPago(id);
    }

    @GetMapping
    public List<TipoPagoEntity> getAllTipoPago() {
        return tipoPagoService.getAllTipoPago();
    }

    @DeleteMapping("/id")
    public void deleteTipoPago(@PathVariable Integer id) {
        tipoPagoService.deleteTipoPago(id);
    }
}
