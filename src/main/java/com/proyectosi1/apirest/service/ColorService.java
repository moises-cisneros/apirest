package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.ColorIdNombreDTO;
import com.proyectosi1.apirest.model.dto.EnvioColorDTO;
import com.proyectosi1.apirest.model.entity.ColorEntity;
import com.proyectosi1.apirest.model.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ColorService {
    // Crea un nuevo registro de color en la base de datos
    private final ColorRepository colorRepository;

    public ColorEntity createColor(ColorEntity color) {
        return colorRepository.save(color);
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

    public EnvioColorDTO sendColor() {
        List<ColorIdNombreDTO> listColor = new ArrayList<>();
        EnvioColorDTO envioColor = new EnvioColorDTO();

        for(int i=1;i <= colorRepository.count() ; i++ ) {
            ColorIdNombreDTO color=new ColorIdNombreDTO();
            color.setId(colorRepository.findById(i).get().getId());
            color.setNombre(colorRepository.findById(i).get().getNombre());
            listColor.add(color);
        }
        envioColor.setColor(listColor);

        return envioColor;
    }
}
