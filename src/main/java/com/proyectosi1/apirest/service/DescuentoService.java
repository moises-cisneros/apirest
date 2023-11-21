package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.DescuentoDTO;
import com.proyectosi1.apirest.model.mapper.DescuentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.DescuentoEntity;
import com.proyectosi1.apirest.model.repository.DescuentoRepository;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DescuentoService {
    @Autowired
    private final DescuentoRepository descuentoRepository;
    @Autowired
    private final DescuentoMapper descuentoMapper;

    public DescuentoDTO saveDescuento(DescuentoDTO descuentoDTO) {
        DescuentoEntity descuentoEntity = descuentoMapper.descuentoDTOtoDescuento(descuentoDTO);
        descuentoRepository.save(descuentoEntity);
        return descuentoMapper.descuentoToDescuentoDTO(descuentoEntity);
    }

    public DescuentoDTO updateDescuento(Integer id, DescuentoDTO descuentoDTO){
        descuentoDTO.setId(id);
        DescuentoEntity descuentoEntity = descuentoMapper.descuentoDTOtoDescuento(descuentoDTO);
        descuentoRepository.save(descuentoEntity);
        return descuentoMapper.descuentoToDescuentoDTO(descuentoEntity);
    }
     
    public DescuentoDTO getDescuento(Integer id) {
        DescuentoEntity descuentoEntity = descuentoRepository.findById(id).orElse(null);
        return descuentoMapper.descuentoToDescuentoDTO(descuentoEntity);
    }

    public List<DescuentoDTO> getDescuentos() {
        List<DescuentoEntity> descuentoEntityList = descuentoRepository.findAll();
        return descuentoMapper.toDescuentoDTOList(descuentoEntityList);
    }

    public void deleteDescuento(Integer id) {
        descuentoRepository.deleteById(id);
    }

}
