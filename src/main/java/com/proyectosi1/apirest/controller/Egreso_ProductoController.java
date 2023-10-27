/*package com.proyectosi1.apirest.controller;

public class Egreso_ProductoController {
    
}*/
package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.entity.Egreso_ProductoEntity;
import com.proyectosi1.apirest.service.Egreso_ProductoService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/egreso_producto")
@RequiredArgsConstructor
public class Egreso_ProductoController {
    private final Egreso_ProductoService egreso_ProductoService;
    
    @PostMapping
    public Egreso_ProductoEntity createCategory(@RequestBody Egreso_ProductoEntity egreso_Producto) {
        return egreso_ProductoService.createEgreso_Producto(egreso_Producto);
    }

    @PutMapping("/{id}")
    public Egreso_ProductoEntity updateCategory(@PathVariable Integer id, @RequestBody Egreso_ProductoEntity egreso_Producto) {
        egreso_Producto.setId(id);
        return egreso_ProductoService.updateEgreso_Producto(egreso_Producto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        egreso_ProductoService.deleteEgreso_Producto(id);
    }

    @GetMapping("/{id}")
    public Egreso_ProductoEntity getCategory(@PathVariable Integer id) {
        return egreso_ProductoService.getEgreso_Producto(id);
    }

    @GetMapping
    public List<Egreso_ProductoEntity> getAllCategory() {
        return egreso_ProductoService.getAllEgreso_Productos();
    }
}

