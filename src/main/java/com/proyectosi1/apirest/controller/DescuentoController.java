package com.proyectosi1.apirest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.entity.DescuentoEntity;
import com.proyectosi1.apirest.service.DescuentoService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/descuento")
public class DescuentoController {
    public final DescuentoService descuentoService;

    @PostMapping
    public DescuentoEntity saveDescuento(@RequestBody DescuentoEntity descuentoEntity){
        return descuentoService.saveDescuento(descuentoEntity);
    }

    @PutMapping("/{id}")
    public DescuentoEntity updateDescuento(@PathVariable Integer id, @RequestBody DescuentoEntity descuentoEntity){
        return descuentoService.updateDescuento(id,descuentoEntity);
    }

    @GetMapping("/{id}")
    public DescuentoEntity getDescuento(@PathVariable Integer id) {   
        return descuentoService.getDescuento(id);
    }

    @GetMapping
    public List<DescuentoEntity> getDescuentos() {
        return descuentoService.getDescuentos();
    }

    @DeleteMapping("/{id}")
    public void deleteDescuento(Integer id) {
        descuentoService.deleteDescuento(id);
    }
    
}
