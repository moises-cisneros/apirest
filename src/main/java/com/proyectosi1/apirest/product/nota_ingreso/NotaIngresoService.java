package com.proyectosi1.apirest.product.nota_ingreso;

import java.util.List;

import com.proyectosi1.apirest.dto.IngresoProductoDTO;
import com.proyectosi1.apirest.dto.NotaIngresoDTO;
import com.proyectosi1.apirest.entity.ProductoEntity;
import com.proyectosi1.apirest.entity.TallaEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoEntity;
import com.proyectosi1.apirest.product.ingreso_producto.IngresoProductoRepository;
import com.proyectosi1.apirest.repository.TallaRepository;
import com.proyectosi1.apirest.service.ProductoService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotaIngresoService {
    private final NotaIngresoRepository nota_IngresoRepository;
    private final NotaIngresoRepository notaIngresoRepository;
    private final IngresoProductoRepository ingresoProductoRepository;
    private final TallaRepository tallaRepository;
    private final ProductoService productoService;

    public NotaIngresoEntity createNotaIngreso(NotaIngresoEntity nota_ingreso){
        return nota_IngresoRepository.save(nota_ingreso);
    }

    // Actualiza un registro de Nota_Egreso en la base de datos
    public NotaIngresoEntity updateNotaIngreso(NotaIngresoEntity nota_ingreso) {
        return nota_IngresoRepository.save((nota_ingreso));
    }

    public void deleteNotaIngreso(Integer id) {
        nota_IngresoRepository.deleteById(id);
    }

    public NotaIngresoEntity getNotaIngreso(Integer id) {
        return nota_IngresoRepository.findById(id).orElse(null);
    }

    public List<NotaIngresoEntity> getAllNotaIngreso() {
        return nota_IngresoRepository.findAll();
    }

    public void createNotaIngreso(NotaIngresoDTO notaIngreso) {
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
            ProductoEntity producto = productoService.getProducto(detalle.getId_producto());
            TallaEntity talla = tallaRepository.findById(detalle.getId_talla()).orElse(null);

            ingresoProducto.setProducto(producto);
            ingresoProducto.setTalla(talla);

            ingresoProductoRepository.save(ingresoProducto);
        }
    }

}

