package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.MarcaDTO;
import com.proyectosi1.apirest.model.entity.MarcaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarcaMapper {

    MarcaEntity marcaDTOToMarca(MarcaDTO marcaDTO);

    MarcaDTO marcaToMarcaDTO(MarcaEntity marcaEntity);

    List<MarcaEntity> listMarca(List<MarcaDTO> marcaDTOList);

    List<MarcaDTO> listMarcaDTO(List<MarcaEntity> marcaEntityList);

}
