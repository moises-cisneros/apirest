package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.model.dto.DescuentoDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.model.entity.DescuentoEntity;
import com.proyectosi1.apirest.service.DescuentoService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/descuento")
public class DescuentoController {
    public final DescuentoService descuentoService;

    @PostMapping
    public DescuentoDTO saveDescuento(@RequestBody DescuentoDTO descuentoDTO){
        return descuentoService.saveDescuento(descuentoDTO);
    }

    @PutMapping("/{id}")
    public DescuentoDTO updateDescuento(@PathVariable Integer id, @RequestBody DescuentoDTO descuentoDTO){
        return descuentoService.updateDescuento(id,descuentoDTO);
    }

    @GetMapping("/{id}")
    public DescuentoDTO getDescuento(@PathVariable Integer id) {
        return descuentoService.getDescuento(id);
    }

    @GetMapping
    public List<DescuentoDTO> getDescuentos() {
        return descuentoService.getDescuentos();
    }

    @DeleteMapping("/{id}")
    public void deleteDescuento(Integer id) {
        descuentoService.deleteDescuento(id);
    }
    
}
