package com.proyectosi1.apirest.controller;

import com.proyectosi1.apirest.config.component.Inicializacion;
import com.proyectosi1.apirest.model.entity.IngresoProductoEntity;
import com.proyectosi1.apirest.service.IngresoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingreso_producto")
@RequiredArgsConstructor
public class IngresoProductoController {
    private final IngresoProductoService ingresoProductoService;
    private final Inicializacion inicializacion;

    @PostMapping
    public IngresoProductoEntity createIngresoProducto(@RequestBody IngresoProductoEntity ingreso_Producto) {
        return ingresoProductoService.createIngresoProducto(ingreso_Producto);
    }

    @PutMapping("/{id}")
    public IngresoProductoEntity updateIngresoProducto(@PathVariable Integer id, @RequestBody IngresoProductoEntity ingreso_Producto) {
        ingreso_Producto.setId(id);
        return ingresoProductoService.updateIngresoProducto(ingreso_Producto);
    }

    @GetMapping
    public List<IngresoProductoEntity> getAllIngresoProducto() {
        return ingresoProductoService.getAllIngresoProductos();
    }

    @PostMapping("/crearTrigger")
    public ResponseEntity<String> crearTrigger() {
        inicializacion.inicializar();
        return ResponseEntity.ok("ElTi-gre funca");
    }

}

