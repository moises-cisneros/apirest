package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.Nota_EgresoEntity;
import com.proyectosi1.apirest.repository.Nota_EgresoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Nota_EgresoService {
    private final Nota_EgresoRepository nota_EgresoRepository;

    public Nota_EgresoEntity createNota_Egreso(Nota_EgresoEntity nota_egreso){
        return nota_EgresoRepository.save(nota_egreso);
    }

    // Actualiza un registro de Nota_Egreso en la base de datos
    public Nota_EgresoEntity updateNota_Egreso(Nota_EgresoEntity nota_egreso) {
        return nota_EgresoRepository.save((nota_egreso));
    }

    public void deleteNota_Egreso(Integer id) {
        nota_EgresoRepository.deleteById(id);
    }

    public Nota_EgresoEntity getNota_Egreso(Integer id) {
        return nota_EgresoRepository.findById(id).orElse(null);
    }

    public List<Nota_EgresoEntity> getAllNota_Egreso() {
        return nota_EgresoRepository.findAll();
    }

}
