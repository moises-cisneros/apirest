package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.dto.*;
import com.proyectosi1.apirest.entity.TallaEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoRepository;
import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoEntity;
import com.proyectosi1.apirest.product.nota_ingreso.NotaIngresoRepository;
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
    private final NotaIngresoRepository notaIngresoRepository;
    private final IngresoProductoRepository ingresoProductoRepository;
 
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

    public List<ProductoEntity> getAllProducto() {
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

    public void setNotaIngreso(NotaIngresoDTO notaIngreso) {
        // Guardo la nota de ingreso
        NotaIngresoEntity notaIngresoEntity = new NotaIngresoEntity();
        notaIngresoEntity.setDescripcion(notaIngreso.getDescripcion());
        notaIngresoEntity.setFecha(notaIngreso.getFecha());

        // id de nota de ingreso
        Integer idNota = notaIngresoRepository.saveAndFlush(notaIngresoEntity).getId();
        
        for (IngresoProductoDTO detalle : notaIngreso.getDetalleIngreso()) {
            IngresoProductoEntity ingresoProducto = new IngresoProductoEntity();

            ingresoProducto.setId_nota_ingreso(notaIngresoEntity);
            ingresoProducto.setCantidad(detalle.getCantidad());
            ingresoProducto.setId(null);
            ProductoEntity producto = getProducto(detalle.getId_producto());
            TallaEntity talla = tallaRepository.findById(detalle.getId_talla()).orElse(null);

            ingresoProducto.setProducto(producto);
            ingresoProducto.setTalla(talla);
            System.out.println(ingresoProducto.toString());
            ingresoProductoRepository.save(ingresoProducto);
        }
    }
}
