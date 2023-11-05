package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {
    private final NotaVentaRepository notaVentaRepository;

    public NotaVentaEntity crearNotaVenta(NotaVentaEntity notaVentaEntity) {
        return notaVentaRepository.save(notaVentaEntity);
    }

    public NotaVentaEntity updateNotaventa(NotaVentaEntity notaVentaEntity) {
        return notaVentaRepository.save(notaVentaEntity);
    }

    public NotaVentaEntity getNotaVenta(Integer Id) {
        return notaVentaRepository.findById(Id).orElse(null);
    }

    public List<NotaVentaEntity> getAllNotaVenta() {
        return notaVentaRepository.findAll();
    }

    public void deleteNotaVenta(Integer Id) {
        notaVentaRepository.deleteById(Id);
    }

}
