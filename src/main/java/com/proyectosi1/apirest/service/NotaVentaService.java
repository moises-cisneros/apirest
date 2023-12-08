package com.proyectosi1.apirest.service;

import com.proyectosi1.apirest.model.dto.EstadoVentaDTO;
import com.proyectosi1.apirest.model.dto.NotaVentaDTO;
import com.proyectosi1.apirest.model.dto.UpdateEstadoDTO;
import com.proyectosi1.apirest.model.mapper.NotaVentaMapper;

import java.util.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {
    @Autowired
    private final NotaVentaRepository notaVentaRepository;
    @Autowired
    private final NotaVentaMapper notaVentaMapper;

    public NotaVentaEntity crearNotaVenta(NotaVentaEntity notaVentaEntity) {
        return notaVentaRepository.save(notaVentaEntity);
    }

    public NotaVentaEntity updateNotaventa(NotaVentaEntity notaVentaEntity) {
        return notaVentaRepository.save(notaVentaEntity);
    }

    public NotaVentaEntity getNotaVenta(Integer Id) {
        return notaVentaRepository.findById(Id).orElse(null);
    }

    public List<NotaVentaEntity> getAllNotaVenta() {
        return notaVentaRepository.findAll();
    }

    public List<NotaVentaDTO> getAllSalesNote() {
        return notaVentaMapper.getAllSalesNote();
    }

    public void deleteNotaVenta(Integer Id) {
        notaVentaRepository.deleteById(Id);
    }

    // Obtener el total de notas de ventas que hay
    public Integer totalQuantityItemsSalesNote() {
        return notaVentaRepository.countAll();
    }

    public List<EstadoVentaDTO> estadoVenta() {
        List<NotaVentaEntity> notaVentaList = notaVentaRepository.findAll();
        List<EstadoVentaDTO> estadoVentaList = new ArrayList<>();

        for (NotaVentaEntity notaVenta : notaVentaList) {
            EstadoVentaDTO auxEstadoVenta = new EstadoVentaDTO();
            auxEstadoVenta.setEstadoVenta(notaVenta.getEstado());
            auxEstadoVenta.setNroNotaVenta(notaVenta.getId());
            auxEstadoVenta.setNombreCliente(notaVenta.getUser().getName());
            auxEstadoVenta.setTipoPago(notaVenta.getTipoPago().getNombre());
            estadoVentaList.add(auxEstadoVenta);
        }

        return estadoVentaList;
    }

    public void updateEstado(UpdateEstadoDTO nuevoEstado) {
        NotaVentaEntity notaVenta = notaVentaRepository.findById(nuevoEstado.getNroNotaVenta()).orElse(null);
        notaVenta.setEstado(nuevoEstado.getNuevoEstado());
        notaVentaRepository.save(notaVenta);
    }

    @Transactional
    public void crearTriggerNotaVenta() {
        notaVentaRepository.crearTrigger();
    }

}
