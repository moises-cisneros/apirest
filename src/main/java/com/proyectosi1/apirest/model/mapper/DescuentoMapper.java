package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.DescuentoDTO;
import com.proyectosi1.apirest.model.entity.DescuentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DescuentoMapper {
    DescuentoEntity descuentoDTOtoDescuento(DescuentoDTO descuentoDTO);

    DescuentoDTO descuentoToDescuentoDTO(DescuentoEntity descuentoEntity);

    List<DescuentoEntity> toDescuentoList(List<DescuentoDTO> descuentoDTOS);

    List<DescuentoDTO> toDescuentoDTOList(List<DescuentoEntity> descuentoEntities);
}
