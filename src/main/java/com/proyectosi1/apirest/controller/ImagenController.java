package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.CatalogoDTO;
import com.proyectosi1.apirest.model.dto.ImagenDTO;
import com.proyectosi1.apirest.model.dto.ProductImageDTO;
import com.proyectosi1.apirest.model.entity.ColorEntity;
import com.proyectosi1.apirest.model.entity.ImagenEntity;
import com.proyectosi1.apirest.model.entity.ProductoEntity;
import com.proyectosi1.apirest.model.entity.TallaEntity;
import com.proyectosi1.apirest.service.ImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/imagen")
@RequiredArgsConstructor
public class ImagenController {

    private final ImagenService imagenService;

    @PostMapping
    public ImagenEntity createImagen(@RequestBody ImagenEntity imagen) {
        return imagenService.createImagen(imagen);
    }

    @PutMapping("/{id}")
    public ImagenEntity updateImagen(@PathVariable Integer id, @RequestBody ImagenEntity imagen) {
        imagen.setId(id);
        return imagenService.updateImagen(imagen);
    }

    @DeleteMapping("/{id}")
    public void deleteImagen(@PathVariable Integer id) {
        imagenService.deleteImagen(id);
    }

    @GetMapping("/{id}")
    public ImagenEntity getImagen(@PathVariable Integer id) {
        return imagenService.getImagen(id);
    }

    @GetMapping
    public List<ImagenEntity> getAllImages() {
        return imagenService.getAllImages();
    }

    @GetMapping("/edit")
    public ImagenDTO editImageUrl(@RequestParam Integer idInventario) {
        return imagenService.editImageUrl(idInventario);
    }

    @GetMapping("/catalogo")
    public List<CatalogoDTO> getCatalogo() {
        return imagenService.getCatalogo();
    }

    @GetMapping("/prueba1")
    public List<TallaEntity> prueba1(@RequestParam Integer idProducto) {
        return imagenService.prueba1(idProducto);
    }

    @GetMapping("/prueba2")
    public List<ColorEntity> prueba2(@RequestParam String name) {
        return imagenService.prueba2(name);
    }

    @GetMapping("/all-product")
    public List<ProductImageDTO> getAllProductImages() {
        return imagenService.getAllProductImages();
    }

}
