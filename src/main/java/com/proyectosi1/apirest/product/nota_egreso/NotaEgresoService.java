package com.proyectosi1.apirest.product.nota_egreso;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.product.nota_egreso.NotaEgresoEntity;
import com.proyectosi1.apirest.product.nota_egreso.NotaEgresoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotaEgresoService {
    private final NotaEgresoRepository notaEgresoRepository;

    public NotaEgresoEntity createNota_Egreso(NotaEgresoEntity nota_egreso){
        return notaEgresoRepository.save(nota_egreso);
    }

    // Actualiza un registro de Nota_Egreso en la base de datos
    public NotaEgresoEntity updateNota_Egreso(NotaEgresoEntity nota_egreso) {
        return notaEgresoRepository.save((nota_egreso));
    }

    public void deleteNota_Egreso(Integer id) {
        notaEgresoRepository.deleteById(id);
    }

    public NotaEgresoEntity getNota_Egreso(Integer id) {
        return notaEgresoRepository.findById(id).orElse(null);
    }

    public List<NotaEgresoEntity> getAllNota_Egreso() {
        return notaEgresoRepository.findAll();
    }

}
