package com.proyectosi1.apirest.product.nota_ingreso;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoEntity;
import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotaIngresoService {
    private final NotaIngresoRepository nota_IngresoRepository;

    public NotaIngresoEntity createNota_Ingreso(NotaIngresoEntity nota_ingreso){
        return nota_IngresoRepository.save(nota_ingreso);
    }

    // Actualiza un registro de Nota_Egreso en la base de datos
    public NotaIngresoEntity updateNota_Ingreso(NotaIngresoEntity nota_ingreso) {
        return nota_IngresoRepository.save((nota_ingreso));
    }

    public void deleteNota_Ingreso(Integer id) {
        nota_IngresoRepository.deleteById(id);
    }

    public NotaIngresoEntity getNota_Ingreso(Integer id) {
        return nota_IngresoRepository.findById(id).orElse(null);
    }

    public List<NotaIngresoEntity> getAllNota_Ingreso() {
        return nota_IngresoRepository.findAll();
    }

}

