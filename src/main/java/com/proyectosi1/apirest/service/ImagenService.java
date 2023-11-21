package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.ImagenDTO;
import com.proyectosi1.apirest.model.entity.ImagenEntity;
import com.proyectosi1.apirest.model.repository.ImagenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;

    public ImagenEntity createImagen(ImagenEntity imagen) {
        return imagenRepository.save(imagen);
    }

    public ImagenEntity updateImagen(ImagenEntity imagen) {
        return imagenRepository.save(imagen);
    }

    public void deleteImagen(Integer id) {
        imagenRepository.deleteById(id);
    }

    public ImagenEntity getImagen(Integer id) {
        return imagenRepository.findById(id).orElse(null);
    }

    public List<ImagenEntity> getAllImages() {
        return imagenRepository.findAll();
    }

    public ImagenDTO editImageUrl(Integer idInventario) {
        ImagenDTO imagenDTO = new ImagenDTO();
        ImagenEntity imagen = imagenRepository.findByInventarioId(idInventario).orElse(null);
        imagenDTO.setId(imagen.getId());
        imagenDTO.setUrl(imagen.getUrl());
        imagenDTO.setIdInventario(imagen.getInventario().getId());

        return imagenDTO;
    }

}
