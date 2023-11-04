package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.BodegaDTO;
import com.proyectosi1.apirest.model.entity.BodegaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "SPRING")
public interface BodegaMapper {

    BodegaEntity bodegaDTOToBodega(BodegaDTO bodegaDTO);

    BodegaDTO bodegaToBodegaDTO(BodegaEntity bodegaEntity);

    List<BodegaEntity> listBodega(List<BodegaDTO> bodegaDTOList);

    List<BodegaDTO> listBodegaDTO(List<BodegaEntity> bodegaEntityList);
}
