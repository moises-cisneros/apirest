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

import com.proyectosi1.apirest.entity.TallaEntity;
import com.proyectosi1.apirest.service.TallaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/talla")
@RequiredArgsConstructor
public class TallaController {
    private final TallaService tallaService;

    @PostMapping
    public TallaEntity crearStockTalla(@RequestBody TallaEntity stockTalla) {
        return tallaService.crearStockTalla(stockTalla);
    }

    @PutMapping("/{id}")
    public TallaEntity updateStockTalla(@RequestBody TallaEntity stockTalla) {
        return tallaService.updateStockTalla(stockTalla);
    }

    @DeleteMapping("/{id}")
    public void deleteStockTalla(@PathVariable Integer id) {
        tallaService.deleteStockTalla(id);
    }

    @GetMapping("/{id}")
    public TallaEntity getStockTalla(@PathVariable Integer id) {
        return tallaService.getStockTalla(id);
    }

    @GetMapping
    public List<TallaEntity> getAllStockTalla() {
        return tallaService.getAllStockTalla();
    }


}
