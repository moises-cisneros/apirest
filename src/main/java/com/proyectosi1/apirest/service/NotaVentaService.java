package com.proyectosi1.apirest.service;

import java.io.File;
import java.io.FileInputStream;

import com.proyectosi1.apirest.model.dto.ReporteDTO;
import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import lombok.NonNull;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.proyectosi1.apirest.model.dto.NotaVentaClienteDTO;
import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.model.repository.DetalleVentaRepository;
import com.proyectosi1.apirest.model.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.util.ResourceUtils;

@Service
@RequiredArgsConstructor
public class NotaVentaService {
    @Autowired
    private final NotaVentaRepository notaVentaRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final DetalleVentaRepository detalleVentaRepository;

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

    public void deleteNotaVenta(Integer Id) {
        notaVentaRepository.deleteById(Id);
    }

    @NonNull
    public ResponseEntity<Resource> exportSalesNoteReport(Integer idNotaVenta) {
        Optional<NotaVentaEntity> notaVenta = notaVentaRepository.findById(idNotaVenta);
        UserEntity cliente = userRepository.findById(notaVenta.get().getUser().getId()).orElse(null);
        Iterable<ReporteDTO> reporteDTOS = parametersDTO(idNotaVenta);
        System.out.println(reporteDTOS);

        // Verificar si la nota de venta existe
        try {
            File file = ResourceUtils.getFile("classpath:NotaVenta.jasper");
            final File imgLogo = ResourceUtils.getFile("classpath:images/logo.png");
            final File imgCheck = ResourceUtils.getFile("classpath:images/check.png");
            final JasperReport report = (JasperReport) JRLoader.loadObject(file);

            // Agregando los parametros del reporte
            final HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("nro_nota_venta", idNotaVenta);
            parameters.put("current_date", LocalDate.now());
            parameters.put("name_cliente", cliente != null ? cliente.getName() : "-----");
            parameters.put("email_cliente", cliente != null ? cliente.getEmail() : "-----");
            parameters.put("phone_cliente", cliente != null ? cliente.getPhone() : null);
            parameters.put("amount", notaVenta.get().getMonto());
            parameters.put("imgLogo", new FileInputStream(imgLogo));
            parameters.put("imgCheck", new FileInputStream(imgCheck));
            parameters.put("sale_detail", new JRBeanCollectionDataSource((Collection<?>) reporteDTOS));

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
            String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
            StringBuilder stringBuilder = new StringBuilder().append("NotaVenta:");
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(stringBuilder
                            .append("Nro:")
                            .append(notaVenta.get().getId())
                            .append(":")
                            .append(sdf)
                            .append(".pdf")
                            .toString())
                    .build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);
            return ResponseEntity.ok().contentLength((long) reporte.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .headers(headers).body(new ByteArrayResource(reporte));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Solucionar el error del bucle infinito de rol y permisos
    public Iterable<ReporteDTO> parametersDTO(Integer idNotaVenta) {
        List<ReporteDTO> reporteDTOS = new ArrayList<>();
        Iterable<DetalleVentaEntity> detalleVentaEntities = detalleVentaRepository.findByVenta(idNotaVenta);

        detalleVentaEntities.forEach(detalleVentaEntity -> {
            ReporteDTO reporteDTO = new ReporteDTO();
            reporteDTO.setCantidad(detalleVentaEntity.getCantidad());
            reporteDTO.setNombre(detalleVentaEntity.getInventario().getProducto().getNombre());
            reporteDTO.setDescuento(
                    detalleVentaEntity.getInventario().getProducto().getDescuento() != null
                            ? detalleVentaEntity.getInventario().getProducto().getDescuento().getDescripcion()
                            : "Sin descuento"
            );
            reporteDTO.setPrecio(detalleVentaEntity.getInventario().getPrecio());
            reporteDTO.setTalla(detalleVentaEntity.getInventario().getTalla().getTalla());
            reporteDTO.setSubtotal(detalleVentaEntity.getCantidad() * detalleVentaEntity.getInventario().getPrecio());

            reporteDTOS.add(reporteDTO);
        });

        return reporteDTOS;
    }

    // Metodo de prueba
    public NotaVentaClienteDTO prueba(Integer idNotaVenta) {
        NotaVentaClienteDTO listNVClienteDTO = new NotaVentaClienteDTO();

        NotaVentaEntity notaVenta = notaVentaRepository.findById(idNotaVenta).orElse(null);
        UserEntity cliente = userRepository.findById(notaVenta.getUser().getId()).orElse(null);

        listNVClienteDTO.setNotaVenta(notaVenta);
        listNVClienteDTO.setCliente(cliente);

        return listNVClienteDTO;

    }

}
