package com.proyectosi1.apirest.service;

import java.util.List;

import com.proyectosi1.apirest.model.dto.EgresoProductoDTO;
import com.proyectosi1.apirest.model.dto.NotaEgresoDTO;
import com.proyectosi1.apirest.model.entity.EgresoProductoEntity;
import com.proyectosi1.apirest.model.entity.NotaEgresoEntity;
import com.proyectosi1.apirest.model.entity.ProductoEntity;
import com.proyectosi1.apirest.model.entity.TallaEntity;
import com.proyectosi1.apirest.model.repository.EgresoProductoRepository;
import com.proyectosi1.apirest.model.repository.NotaEgresoRepository;
import com.proyectosi1.apirest.model.repository.TallaRepository;

import org.hibernate.query.sqm.sql.ConversionException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotaEgresoService {
    private final NotaEgresoRepository notaEgresoRepository;
    private final EgresoProductoRepository egresoProductoRepository;
    private final TallaRepository tallaRepository;
    private final ProductoService productoService;

    // Actualiza un registro de Nota_Egreso en la base de datos
    public NotaEgresoEntity updateNota_Egreso(NotaEgresoEntity nota_egreso) {
        return notaEgresoRepository.save((nota_egreso));
    }

    public void deleteNota_Egreso(Integer id) {
        notaEgresoRepository.deleteById(id);
    }

    public NotaEgresoEntity getNota_Egreso(Integer id) {
        return notaEgresoRepository.findById(id).orElse(null);
    }

    public List<NotaEgresoEntity> getAllNota_Egreso() {
        return notaEgresoRepository.findAll();
    }

    public void createNota_Egreso(NotaEgresoDTO notaEgreso) throws ConversionException{
        NotaEgresoEntity notaEgresoEntity = new NotaEgresoEntity();
        notaEgresoEntity.setDescripcion(notaEgreso.getDescripcion());
        notaEgresoEntity.setFecha(notaEgreso.getFecha());

        Integer idNota = notaEgresoRepository.saveAndFlush(notaEgresoEntity).getId();

        try {
            
            for (EgresoProductoDTO detalle : notaEgreso.getDetalleIngreso()) {
                EgresoProductoEntity egresoProductoEntity = new EgresoProductoEntity();
    
                egresoProductoEntity.setId_nota_egreso(notaEgresoEntity);
                egresoProductoEntity.setCantidad(detalle.getCantidad());
                egresoProductoEntity.setId(null);
    
                ProductoEntity producto = productoService.getProducto(detalle.getId_producto());
                TallaEntity talla = tallaRepository.findById(detalle.getId_talla()).orElse(null);
    
    
                egresoProductoEntity.setProducto(producto);
                egresoProductoEntity.setTalla(talla);
    
                egresoProductoRepository.save(egresoProductoEntity);
            }
        } catch (Exception e) {
            notaEgresoRepository.deleteById(idNota);
            System.out.println("gsdfd-----"+idNota);
            throw new ConversionException("Error al procesar la nota de egreso", e);
        }
    }

}
