package com.proyectosi1.apirest.config.component;

import com.proyectosi1.apirest.service.DetalleVentaService;
import com.proyectosi1.apirest.service.EgresoProductoService;
import com.proyectosi1.apirest.service.IngresoProductoService;
import com.proyectosi1.apirest.service.NotaVentaService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Inicializacion {

    private final IngresoProductoService ingresoProductoService;
    private final DetalleVentaService detalleVentaService;
    private final NotaVentaService notaVentaService;
    private final EgresoProductoService egresoProductoService;

    // Iniciacializacion de los triggers
    @PostConstruct
    public void inicializar() {
        ingresoProductoService.crearTriggerEnProducto();
        detalleVentaService.crearTriggerEnDetalleVenta();
        notaVentaService.crearTriggerNotaVenta();
        egresoProductoService.triggerEgresoProducto();
    }

}
