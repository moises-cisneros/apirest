package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import com.proyectosi1.apirest.model.entity.InventarioEntity;
import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.DetalleVentaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final NotaVentaService notaVentaService;

    public DetalleVentaEntity createDetalleVenta(DetalleVentaEntity detalleVentaEntity){
        return detalleVentaRepository.save(detalleVentaEntity);
    }

    public void createDetalleVentaList(List<DetalleVentaEntity> detalleVenta){
        
        NotaVentaEntity notaVentaEntity = notaVentaService.crearNotaVenta(detalleVenta.get(0).getNotaVenta());
        detalleVenta.forEach(detalleVentaEntity -> {
            detalleVentaEntity.setNotaVenta(notaVentaService.crearNotaVenta(notaVentaEntity));
            createDetalleVenta(detalleVentaEntity);
        });
        
    }

    public DetalleVentaEntity updateDetalleVenta(Integer id, DetalleVentaEntity detalleVentaEntity){
        detalleVentaEntity.setId(id);
        return detalleVentaRepository.save((detalleVentaEntity));
    }

    public DetalleVentaEntity getDetalleVenta(Integer id){
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public List<DetalleVentaEntity> getAllDetalleVenta(){
        return detalleVentaRepository.findAll();
    }

    public void deleteDetalleVenta(Integer id){
        detalleVentaRepository.deleteById(id);
    }

    // Metodo de prueba
    public Iterable<DetalleVentaEntity> prueba(Integer idNotaVenta) {
        return detalleVentaRepository.findByVenta(idNotaVenta);
    }

    @Transactional
    public void crearTriggerEnDetalleVenta() {
        detalleVentaRepository.crearTrigger();
    }

}
