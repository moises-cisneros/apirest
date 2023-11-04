package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.DescuentoEntity;
import com.proyectosi1.apirest.repository.DescuentoRepository;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DescuentoService {
    private final DescuentoRepository descuentoRepository;

    public DescuentoEntity saveDescuento(DescuentoEntity descuento) {
        return descuentoRepository.save(descuento);
    }

    public DescuentoEntity updateDescuento(Integer id, DescuentoEntity descuento){
        descuento.setId(id);
        return descuentoRepository.save(descuento);
    }
     
    public DescuentoEntity getDescuento(Integer id) {
        return descuentoRepository.findById(id).orElse(null);
    }

    public List<DescuentoEntity> getDescuentos() {
        return descuentoRepository.findAll();
    }

    public void deleteDescuento(Integer id) {
        descuentoRepository.deleteById(id);
    }


}
