package com.proyectosi1.apirest.service;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.dto.EnvioMarcaDTO;
import com.proyectosi1.apirest.dto.EnvioProductoTallaDTO;
import com.proyectosi1.apirest.dto.ListaMarcaIdDTO;
import com.proyectosi1.apirest.dto.MarcaIdNombreDTO;
import com.proyectosi1.apirest.dto.ProductoDTO;
import com.proyectosi1.apirest.dto.TallaDTO;
import com.proyectosi1.apirest.entity.MarcaEntity;
import com.proyectosi1.apirest.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaEntity createMarca(MarcaEntity marca) {
        return marcaRepository.save(marca);
    }

    // Actualiza un registro de color en la base de datos
    public MarcaEntity updateMarca(MarcaEntity marca) {
        return marcaRepository.save((marca));
    }

    public void deleteMarca(Integer id) {
        marcaRepository.deleteById(id);
    }

    public MarcaEntity getMarca(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public List<MarcaEntity> getAllMarca() {
        return marcaRepository.findAll();
    }

    public EnvioMarcaDTO sendMarca() {
        List<MarcaIdNombreDTO> listMarca = new ArrayList<>();
        EnvioMarcaDTO envioMarca = new EnvioMarcaDTO();

        for(int i=1;i <= marcaRepository.count() ; i++ ) {
            MarcaIdNombreDTO marca=new MarcaIdNombreDTO();
            marca.setId(marcaRepository.findById(i).get().getId());
            marca.setNombre(marcaRepository.findById(i).get().getNombre());
            listMarca.add(marca);
        }
        envioMarca.setMarca(listMarca);

        return envioMarca;
    }

}
