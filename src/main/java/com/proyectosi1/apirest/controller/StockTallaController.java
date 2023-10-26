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

import com.proyectosi1.apirest.entity.StockTallaEntity;
import com.proyectosi1.apirest.service.StockTallaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stocktalla")
@RequiredArgsConstructor
public class StockTallaController {
    private final StockTallaService stockTallaService;

    @PostMapping
    public StockTallaEntity crearStockTalla(@RequestBody StockTallaEntity stockTalla) {
        return stockTallaService.crearStockTalla(stockTalla);
    }

    @PutMapping("/{id}")
    public StockTallaEntity updateStockTalla(@RequestBody StockTallaEntity stockTalla) {
        return stockTallaService.updateStockTalla(stockTalla);
    }

    @DeleteMapping("/{id}")
    public void deleteStockTalla(@PathVariable Integer id) {
        stockTallaService.deleteStockTalla(id);
    }

    @GetMapping("/{id}")
    public StockTallaEntity getStockTalla(@PathVariable Integer id) {
        return stockTallaService.getStockTalla(id);
    }

    @GetMapping
    public List<StockTallaEntity> getAllStockTalla() {
        return stockTallaService.getAllStockTalla();
    }


}
