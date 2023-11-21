package com.proyectosi1.apirest.model.mapper;

import com.proyectosi1.apirest.model.dto.TallaDTO;
import com.proyectosi1.apirest.model.entity.TallaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TallaMapper {

    TallaEntity tallaDTOToTalla(TallaDTO tallaDTO);

    TallaDTO tallaToTallDTO(TallaEntity tallaEntity);

    List<TallaEntity> listTalla(List<TallaDTO> tallaDTOList);

    List<TallaDTO> listTallaDTO(List<TallaEntity> tallaEntityList);

}
