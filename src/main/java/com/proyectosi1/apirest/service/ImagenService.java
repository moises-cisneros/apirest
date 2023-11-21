package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.CatalogoDTO;
import com.proyectosi1.apirest.model.dto.ImagenDTO;
import com.proyectosi1.apirest.model.entity.ImagenEntity;
import com.proyectosi1.apirest.model.entity.InventarioEntity;
import com.proyectosi1.apirest.model.repository.ImagenRepository;
import com.proyectosi1.apirest.model.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final InventarioRepository inventarioRepository;

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
        List<ImagenEntity> imagenes = imagenRepository.findByInventarioId(idInventario);

        if (!imagenes.isEmpty()) {
            ImagenEntity imagen = imagenes.get(0); // Puedes obtener la primera imagen de la lista
            imagenDTO.setId(imagen.getId());
            imagenDTO.setUrl(imagen.getUrl());
            imagenDTO.setIdInventario(imagen.getInventario().getId());
        }

        return imagenDTO;
    }


    public List<CatalogoDTO> getCatalogo() {
        List<CatalogoDTO> catalogoDTOList = new ArrayList<>();
        List<InventarioEntity> inventarioEntityList = inventarioRepository.findAll();

        for (InventarioEntity inventario : inventarioEntityList) {
            CatalogoDTO catalogoDTO = new CatalogoDTO();

            // Obteniendo la imagen para el inventario actual
            ImagenDTO imagenDTO = editImageUrl(inventario.getId());

            // Verificando si la imagen es válida antes de agregar el producto al catálogo
            if (imagenDTO != null && imagenDTO.getId() != null && imagenDTO.getUrl() != null) {
                catalogoDTO.setId(imagenDTO.getId());
                catalogoDTO.setUrl(imagenDTO.getUrl());

                // Obteniendo el nombre del producto del inventario actual
                String nombreProducto = inventario.getProducto().getNombre();
                catalogoDTO.setNombreProducto(nombreProducto);

                catalogoDTO.setPrecio(inventario.getPrecio());
                catalogoDTO.setStock(inventario.getCantidad());

                catalogoDTOList.add(catalogoDTO);
            }
        }

        return catalogoDTOList;
    }


}
