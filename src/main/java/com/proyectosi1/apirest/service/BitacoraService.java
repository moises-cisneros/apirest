package com.proyectosi1.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.BitacoraEntity;
import com.proyectosi1.apirest.model.repository.BitacoraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BitacoraService {
    private final BitacoraRepository bitacoraRepository;

    public BitacoraEntity saveBitacora(BitacoraEntity bitacoraEntity){
        return bitacoraRepository.save(bitacoraEntity);
    }

    public List<BitacoraEntity> findAllBitacora(){
        return bitacoraRepository.findAll();
    }

    public BitacoraEntity findBitacoraById(Integer id){
        return bitacoraRepository.findById(id).orElseThrow();
    }

    public void deleteBitacora(Integer id){
        bitacoraRepository.deleteById(id);
    }

    public BitacoraEntity updateBitacora(BitacoraEntity bitacoraEntity){
        return bitacoraRepository.save(bitacoraEntity);
    }
    
}
