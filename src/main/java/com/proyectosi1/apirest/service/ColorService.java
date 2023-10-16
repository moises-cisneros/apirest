package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.entity.ColorEntity;
import com.proyectosi1.apirest.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ColorService {
    // Crea un nuevo registro de color en la base de datos
    private final ColorRepository colorRepository;

    public ColorEntity createColor(ColorEntity color) {
        return (ColorEntity) colorRepository.save(color);
    }

    // Actualiza un registro de color en la base de datos
    public ColorEntity updateColor(ColorEntity color) {
        return colorRepository.save((color));
    }

    public void deleteColor(Integer id) {
        colorRepository.deleteById(id);
    }

    public ColorEntity getColor(Integer id) {
        return colorRepository.findById(id).orElse(null);
    }

    public List<ColorEntity> getAllColors() {
        return colorRepository.findAll();
    }
}
