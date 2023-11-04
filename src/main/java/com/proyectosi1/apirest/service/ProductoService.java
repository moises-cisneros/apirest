package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.EnvioProductoTallaDTO;
import com.proyectosi1.apirest.model.dto.ProductoDTO;
import com.proyectosi1.apirest.model.dto.RequestProductoDTO;
import com.proyectosi1.apirest.model.dto.TallaDTO;
import com.proyectosi1.apirest.model.entity.*;
import com.proyectosi1.apirest.model.mapper.ProductoMapper;
import com.proyectosi1.apirest.model.repository.TallaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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

    public EnvioProductoTallaDTO sendProductSize() {
        List<ProductoDTO> listProductos = new ArrayList<>();
        EnvioProductoTallaDTO envioProductoTalla = new EnvioProductoTallaDTO();

        List<TallaDTO> listTalla = new ArrayList<>();

        for (ProductoEntity productoEntity: productoRepository.findAll()) {
            ProductoDTO producto = new ProductoDTO();
            producto.setId(productoEntity.getId());
            producto.setNombre(productoEntity.getNombre());
            listProductos.add(producto);
        }

        for (TallaEntity tallaEntity: tallaRepository.findAll()) {
            TallaDTO talla = new TallaDTO();
            talla.setId(tallaEntity.getId());
            talla.setTalla(tallaEntity.getTalla());
            listTalla.add(talla);
        }

        envioProductoTalla.setTallas(listTalla);
        envioProductoTalla.setProductos(listProductos);

        return envioProductoTalla;
    }

    public ProductoEntity guardarProducto(RequestProductoDTO productoDTO) {
        ProductoEntity producto = new ProductoEntity();
        ColorEntity color = new ColorEntity();
        MarcaEntity marca = new MarcaEntity();
        CategoryEntity categoria = new CategoryEntity();

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());

        marca.setId(productoDTO.getId_marca());
        color.setId(productoDTO.getId_color());
        categoria.setId(productoDTO.getId_categoria());

        producto.setMarca(marca);
        producto.setColor(color);
        producto.setCategoria(categoria);

        productoRepository.save(producto);

        return producto;
    }

}
