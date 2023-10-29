package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.Nota_IngresoEntity;
import com.proyectosi1.apirest.repository.Nota_IngresoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Nota_IngresoService {
    private final Nota_IngresoRepository nota_IngresoRepository;

    public Nota_IngresoEntity createNota_Ingreso(Nota_IngresoEntity nota_ingreso){
        return nota_IngresoRepository.save(nota_ingreso);
    }

    // Actualiza un registro de Nota_Egreso en la base de datos
    public Nota_IngresoEntity updateNota_Ingreso(Nota_IngresoEntity nota_ingreso) {
        return nota_IngresoRepository.save((nota_ingreso));
    }

    public void deleteNota_Ingreso(Integer id) {
        nota_IngresoRepository.deleteById(id);
    }

    public Nota_IngresoEntity getNota_Ingreso(Integer id) {
        return nota_IngresoRepository.findById(id).orElse(null);
    }

    public List<Nota_IngresoEntity> getAllNota_Ingreso() {
        return nota_IngresoRepository.findAll();
    }

}

