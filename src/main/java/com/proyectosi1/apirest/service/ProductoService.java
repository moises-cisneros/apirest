package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.dto.EnvioProductoTallaDTO;
import com.proyectosi1.apirest.dto.NotaIngresoDTO;
import com.proyectosi1.apirest.dto.ProductoDTO;
import com.proyectosi1.apirest.dto.TallaDTO;
import com.proyectosi1.apirest.repository.TallaRepository;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.entity.ProductoEntity;
import com.proyectosi1.apirest.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final TallaRepository tallaRepository;

    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public ProductoEntity updateProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    public ProductoEntity getProducto(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<ProductoEntity> getAllProducto(){
        return productoRepository.findAll();
    }

    public EnvioProductoTallaDTO sendProductSize() {
        List<ProductoDTO> listProductos = new ArrayList<>();
        EnvioProductoTallaDTO envioProductoTalla = new EnvioProductoTallaDTO();
        List<TallaDTO> listTalla = new ArrayList<>();


        for (int i = 1; i <= productoRepository.count(); i++) {
            ProductoDTO producto = new ProductoDTO();
            producto.setId(productoRepository.findById(i).get().getId());
            producto.setNombre(productoRepository.findById(i).get().getNombre());
            listProductos.add(producto);
        }

        for (int i = 1; i <= tallaRepository.count(); i++) {
            TallaDTO talla = new TallaDTO();
            talla.setId(tallaRepository.findById(i).get().getId());
            talla.setNombre(tallaRepository.findById(i).get().getTalla());
            listTalla.add(talla);
        }

        envioProductoTalla.setTallas(listTalla);
        envioProductoTalla.setProductos(listProductos);

        return envioProductoTalla;
    }
}
