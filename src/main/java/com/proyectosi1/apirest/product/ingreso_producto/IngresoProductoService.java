package com.proyectosi1.apirest.product.ingreso_producto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IngresoProductoService {
    private final IngresoProductoRepository ingreso_ProductoRepository;

    public IngresoProductoEntity createIngreso_Producto(IngresoProductoEntity ingreso_Producto){
        return ingreso_ProductoRepository.save(ingreso_Producto);
    }

    // Actualiza un registro de Ingreso_Producto en la base de datos
    public IngresoProductoEntity updateIngreso_Producto(IngresoProductoEntity ingreso_Producto) {
        return ingreso_ProductoRepository.save((ingreso_Producto));
    }

    public void deleteIngreso_Producto(Integer id) {
        ingreso_ProductoRepository.deleteById(id);
    }

    public IngresoProductoEntity getIngreso_Producto(Integer id) {
        return ingreso_ProductoRepository.findById(id).orElse(null);
    }

    public List<IngresoProductoEntity> getAllIngreso_Productos() {
        return ingreso_ProductoRepository.findAll();
    }

}