package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.ColorDTO;
import com.proyectosi1.apirest.model.entity.ColorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    ColorEntity colorDTOToColor(ColorDTO colorDTO);

    ColorDTO colorToColorDTO(ColorEntity colorEntity);

    List<ColorEntity> listColor(List<ColorDTO> colorDTOList);

    List<ColorDTO> listColorDTO(List<ColorEntity> colorEntityList);

}
