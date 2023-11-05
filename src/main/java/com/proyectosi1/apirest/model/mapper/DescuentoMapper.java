package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.DescuentoDTO;
import com.proyectosi1.apirest.model.entity.DescuentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DescuentoMapper {
    DescuentoEntity toEntity(DescuentoDTO descuentoDTO);
    DescuentoDTO toDto(DescuentoEntity descuentoEntity);

    List<DescuentoEntity> toEntityList(List<DescuentoDTO> descuentoDTOS);
    List<DescuentoDTO> toDTOList(List<DescuentoEntity> descuentoEntities);
}
