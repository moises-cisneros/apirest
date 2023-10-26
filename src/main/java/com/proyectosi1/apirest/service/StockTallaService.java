package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.StockTallaEntity;
import com.proyectosi1.apirest.repository.StockTallaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTallaService {
    private final StockTallaRepository stockTallaRepository;    

    public StockTallaEntity crearStockTalla(StockTallaEntity stockTalla){
        return stockTallaRepository.save(stockTalla);
    }

    public StockTallaEntity updateStockTalla(StockTallaEntity stockTalla){
        return stockTallaRepository.save((stockTalla));
    }

    public void deleteStockTalla(Integer Id) {
        stockTallaRepository.deleteById(Id);
    }

    public StockTallaEntity getStockTalla(Integer id) {
        return stockTallaRepository.findById(id).orElse(null);
    }

    public List<StockTallaEntity> getAllStockTalla() {
        return stockTallaRepository.findAll();
    }
}
