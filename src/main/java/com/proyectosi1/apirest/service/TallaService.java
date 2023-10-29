package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.TallaEntity;
import com.proyectosi1.apirest.repository.TallaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TallaService {
    private final TallaRepository tallaRepository;

    public TallaEntity crearStockTalla(TallaEntity stockTalla){
        return tallaRepository.save(stockTalla);
    }

    public TallaEntity updateStockTalla(TallaEntity stockTalla){
        return tallaRepository.save((stockTalla));
    }

    public void deleteStockTalla(Integer Id) {
        tallaRepository.deleteById(Id);
    }

    public TallaEntity getStockTalla(Integer id) {
        return tallaRepository.findById(id).orElse(null);
    }

    public List<TallaEntity> getAllStockTalla() {
        return tallaRepository.findAll();
    }
}
