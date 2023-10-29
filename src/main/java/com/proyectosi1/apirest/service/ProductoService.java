package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.dto.*;
import com.proyectosi1.apirest.entity.TallaEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoId;
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

    private static Integer count=0;

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
        //NotaIngresoDTO notaIngreso = new NotaIngresoDTO();

        // Guardo la nota de ingreso
        NotaIngresoEntity notaIngresoEntity = new NotaIngresoEntity();
        notaIngresoEntity.setDescripcion(notaIngreso.getDescripcion());
        notaIngresoEntity.setFecha(notaIngreso.getFecha());

        // id de nota de ingreso
        Integer idNota = notaIngresoRepository.saveAndFlush(notaIngresoEntity).getId();


        /*
        // Guardar los detalle ingreso
        for (int i = 0; i < notaIngreso.getDetalleIngreso().size(); i++) {
            IngresoProductoEntity ingresoProducto = new IngresoProductoEntity();

            // Verificacion
            //System.out.println(ingresoProductoRepository.findMaxId());
            System.out.println("Id nota" + idNota);

            IngresoProductoId ids = new IngresoProductoId();
            ids.setId_nota_ingreso(idNota);
            //ids.setId(ingresoProductoRepository.findMaxId() + 1);
            count++;
            System.out.println("Count" + count);
            ids.setId(count);

            ingresoProducto.setId(ids);
            ingresoProducto.setCantidad(notaIngreso.getDetalleIngreso().get(i).getCantidad());

            ProductoEntity producto = new ProductoEntity();
            TallaEntity talla = new TallaEntity();

            producto.setId(notaIngreso.getDetalleIngreso().get(i).getId_producto());
            talla.setId(notaIngreso.getDetalleIngreso().get(i).getId_talla());

            ingresoProducto.setProducto(producto);
            ingresoProducto.setTalla(talla);

            ingresoProductoRepository.save(ingresoProducto);

         */

        for (IngresoProductoDTO detalle : notaIngreso.getDetalleIngreso()) {
            IngresoProductoEntity ingresoProducto = new IngresoProductoEntity();

            IngresoProductoId ids = new IngresoProductoId();
            ids.setId_nota_ingreso(notaIngresoEntity.getId()); // Asignar el ID de la nota de ingreso

            ingresoProducto.setId(ids);
            ingresoProducto.setCantidad(detalle.getCantidad());

            ProductoEntity producto = productoRepository.getById(detalle.getId_producto());
            TallaEntity talla = tallaRepository.getById(detalle.getId_talla());

            ingresoProducto.setProducto(producto);
            ingresoProducto.setTalla(talla);

            ingresoProductoRepository.save(ingresoProducto);
        }
    }
}
