package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.MarcaDTO;
import com.proyectosi1.apirest.model.mapper.MarcaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.MarcaEntity;
import com.proyectosi1.apirest.model.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarcaService {
    @Autowired
    private final MarcaRepository marcaRepository;
    @Autowired
    private final MarcaMapper marcaMapper;

    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        MarcaEntity marcaEntity = marcaMapper.marcaDTOToMarca(marcaDTO);
        marcaRepository.save(marcaEntity);
        return marcaMapper.marcaToMarcaDTO(marcaEntity);
    }

    // Actualiza un registro de color en la base de datos
    public MarcaDTO updateMarca(MarcaDTO marcaDTO) {
        MarcaEntity marcaEntity = marcaMapper.marcaDTOToMarca(marcaDTO);
        marcaRepository.save(marcaEntity);
        return marcaMapper.marcaToMarcaDTO(marcaEntity);
    }

    public void deleteMarca(Integer id) {
        marcaRepository.deleteById(id);
    }

    public MarcaDTO getMarca(Integer id) {
        MarcaEntity marcaEntity = marcaRepository.findById(id).orElse(null);
        return marcaMapper.marcaToMarcaDTO(marcaEntity);
    }

    public List<MarcaDTO> getAllMarca() {
        List<MarcaEntity> marcaEntityList = marcaRepository.findAll();
        return marcaMapper.listMarcaDTO(marcaEntityList);
    }

}
