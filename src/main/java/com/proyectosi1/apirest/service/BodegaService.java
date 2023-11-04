package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.BodegaDTO;
import com.proyectosi1.apirest.model.mapper.BodegaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.BodegaEntity;
import com.proyectosi1.apirest.model.repository.BodegaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BodegaService {

    @Autowired
    private final BodegaRepository bodegaRepository;
    @Autowired
    private final BodegaMapper bodegaMapper;

    public BodegaDTO createBodega(BodegaDTO bodegaDTO) {
        BodegaEntity bodega = bodegaMapper.bodegaDTOToBodega(bodegaDTO);
        bodegaRepository.save(bodega);
        return bodegaMapper.bodegaToBodegaDTO(bodega);
    }

    public BodegaDTO updateBodega(BodegaDTO bodegaDTO) {
        BodegaEntity bodega = bodegaMapper.bodegaDTOToBodega(bodegaDTO);
        bodegaRepository.save(bodega);
        return bodegaMapper.bodegaToBodegaDTO(bodega);
    }

    public void deleteBodega(Integer id) {
        bodegaRepository.deleteById(id);
    }

    public BodegaDTO getBodega(Integer id) {
        BodegaEntity bodega = bodegaRepository.findById(id).orElse(null);
        return bodegaMapper.bodegaToBodegaDTO(bodega);
    }

    public List<BodegaDTO> getAllBodegas() {
        List<BodegaEntity> bodegaEntities = bodegaRepository.findAll();
        return bodegaMapper.listBodegaDTO(bodegaEntities);
    }

}
