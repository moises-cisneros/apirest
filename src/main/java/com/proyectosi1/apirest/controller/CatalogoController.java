package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.CatalogoDTO;
import com.proyectosi1.apirest.model.dto.ProductImageDTO;
import com.proyectosi1.apirest.service.CatalogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
@RequiredArgsConstructor
public class CatalogoController {

    private final CatalogoService catalogoService;


    /*@GetMapping("/edit")
    public ImagenDTO editImageUrl(@RequestParam Integer idInventario) {
        return imagenService.editImageUrl(idInventario);
    }*/

    @GetMapping
    public List<CatalogoDTO> getCatalogo() {
        return catalogoService.getCatalogo();
    }

    @GetMapping("/all-product")
    public List<ProductImageDTO> getAllProductImages() {
        return catalogoService.getAllProductImages();
    }

    @PutMapping("/available/{id}")
    public void productAvailability(@PathVariable Integer id, @RequestParam boolean disponible) {
        catalogoService.productAvailability(id, disponible);
    }

}
