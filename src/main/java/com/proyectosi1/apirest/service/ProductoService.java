package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.ProductoDTO;
import com.proyectosi1.apirest.model.entity.*;
import com.proyectosi1.apirest.model.mapper.ProductoMapper;
import com.proyectosi1.apirest.model.repository.TallaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;
    @Autowired
    private final ProductoMapper productoMapper;
    private final TallaRepository tallaRepository;
 
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = productoMapper.productoDTOToProducto(productoDTO);
        productoRepository.save(productoEntity);
        return productoMapper.productoToProductoDTO(productoEntity);
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

    public List<ProductoEntity> getAllProducto() {
        return productoRepository.findAll();
    }

}
