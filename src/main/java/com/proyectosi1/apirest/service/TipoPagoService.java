package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.TipoPagoEntity;
import com.proyectosi1.apirest.model.repository.TipoPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoPagoService {
    private final TipoPagoRepository tipoPagoRepository;

    public TipoPagoEntity createTipoPago(TipoPagoEntity tipoPagoEntity) {
        return tipoPagoRepository.save(tipoPagoEntity);
    }

    public TipoPagoEntity updateTipoPago(TipoPagoEntity tipoPagoEntity) {
        return tipoPagoRepository.save(tipoPagoEntity);
    }

    public TipoPagoEntity getTipoPago(Integer Id) {
        return tipoPagoRepository.findById(Id).orElse(null);
    }

    public List<TipoPagoEntity> getAllTipoPago() {
        return tipoPagoRepository.findAll();
    }

    public void deleteTipoPago(Integer Id) {
        tipoPagoRepository.deleteById(Id);
    }
}
