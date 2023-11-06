package com.proyectosi1.apirest.service;

import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {
    @Autowired
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
