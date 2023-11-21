package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.ColorDTO;
import com.proyectosi1.apirest.model.entity.ColorEntity;
import com.proyectosi1.apirest.model.mapper.ColorMapper;
import com.proyectosi1.apirest.model.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ColorService {
    // Crea un nuevo registro de color en la base de datos
    @Autowired
    private final ColorRepository colorRepository;
    @Autowired
    private final ColorMapper colorMapper;

    public ColorDTO createColor(ColorDTO colorDTO) {
        ColorEntity colorEntity = colorMapper.colorDTOToColor(colorDTO);
        colorRepository.save(colorEntity);
        return colorMapper.colorToColorDTO(colorEntity);
    }

    // Actualiza un registro de color en la base de datos
    public ColorDTO updateColor(ColorDTO colorDTO) {
        ColorEntity colorEntity = colorMapper.colorDTOToColor(colorDTO);
        colorRepository.save(colorEntity);
        return colorMapper.colorToColorDTO(colorEntity);
    }

    public void deleteColor(Integer id) {
        colorRepository.deleteById(id);
    }

    public ColorDTO getColor(Integer id) {
        ColorEntity colorEntity = colorRepository.findById(id).orElse(null);
        return colorMapper.colorToColorDTO(colorEntity);
    }

    public List<ColorDTO> getAllColors() {
        List<ColorEntity> colorEntityList = colorRepository.findAll();
        return colorMapper.listColorDTO(colorEntityList);
    }

}
