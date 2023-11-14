package com.proyectosi1.apirest.service;

import java.io.File;
import java.io.FileInputStream;

import com.proyectosi1.apirest.model.dto.EstadoVentaDTO;
import com.proyectosi1.apirest.model.dto.NotaVentaDTO;
import com.proyectosi1.apirest.model.dto.TableParametersDTO;
import com.proyectosi1.apirest.model.dto.UpdateEstadoDTO;
import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import com.proyectosi1.apirest.model.mapper.NotaVentaMapper;
import lombok.NonNull;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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

    @NonNull
    public ResponseEntity<Resource> exportReportNoteSale(Integer idNotaVenta) {
        // Verificar si la nota de venta existe
        try {
            byte[] report = reportNoteSale(idNotaVenta);

            // Construir un nombre del archivo que incluya el número de la Nota de Venta y la fecha
            String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
            StringBuilder stringBuilder = new StringBuilder().append("NotaVenta:");

            // Configurar el encabezado para indicar la disposición del contenido como un archivo adjunto
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(stringBuilder
                            .append("Nro:")
                            .append(idNotaVenta)
                            .append(":")
                            .append(sdf)
                            .append(".pdf")
                            .toString())
                    .build();

            // Configurar los encabezados HTTP, incluyendo la disposición del contenido y agregar el nombre del archivo
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);

            // Construir y devolver una respuesta HTTP con el informe PDF adjunto
            return ResponseEntity.ok()
                    .contentLength(report.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .headers(headers)
                    .body(new ByteArrayResource(report));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    public byte[] reportNoteSale(Integer idNotaVenta) {

        // Obtener la nota de venta, el cliente y los parametros de la tabla sale_detail
        Optional<NotaVentaEntity> notaVenta = notaVentaRepository.findById(idNotaVenta);
        UserEntity cliente = userRepository.findById(notaVenta.get().getUser().getId()).orElse(null);
        Iterable<TableParametersDTO> tableParametersDTOS = tableParameters(idNotaVenta);

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
            parameters.put("phone_cliente", cliente != null ? cliente.getPhone() : "-----");
            parameters.put("amount", notaVenta.get().getMonto());
            parameters.put("imgLogo", new FileInputStream(imgLogo));
            parameters.put("imgCheck", new FileInputStream(imgCheck));
            parameters.put("sale_detail", new JRBeanCollectionDataSource((Collection<?>) tableParametersDTOS));

            // Llenar el informe Jasper con los datos proporcionados y exportarlo a un arreglo de bytes en formato PDF
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener la cantidad, precio, nombre del producto, subtotal, descuento y la talla para rellenar la tabla
    public List<TableParametersDTO> tableParameters(Integer idNotaVenta) {
        List<TableParametersDTO> tableParametersDTOS = new ArrayList<>();
        Iterable<DetalleVentaEntity> detalleVentaEntities = detalleVentaRepository.findByVenta(idNotaVenta);

        detalleVentaEntities.forEach(detalleVentaEntity -> {
            TableParametersDTO tableParametersDTO = new TableParametersDTO();
            tableParametersDTO.setCantidad(detalleVentaEntity.getCantidad());
            tableParametersDTO.setNombre(detalleVentaEntity.getInventario().getProducto().getNombre());
            tableParametersDTO.setDescuento(
                    detalleVentaEntity.getInventario().getProducto().getDescuento() != null
                            ? detalleVentaEntity.getInventario().getProducto().getDescuento().getDescripcion()
                            : "Sin descuento"
            );
            tableParametersDTO.setPrecio(detalleVentaEntity.getInventario().getPrecio());
            tableParametersDTO.setTalla(detalleVentaEntity.getInventario().getTalla().getTalla());
            tableParametersDTO.setSubtotal(detalleVentaEntity.getCantidad() * detalleVentaEntity.getInventario().getPrecio());

            tableParametersDTOS.add(tableParametersDTO);
        });

        return tableParametersDTOS;
    }

    // Obtener el total de notas de ventas que hay
    public Integer totalQuantityItemsSalesNote() {
        return notaVentaRepository.countAll();
    }

    public List<EstadoVentaDTO> estadoVenta() {
        List<NotaVentaEntity> notaVentaList = notaVentaRepository.findAll();
        List<EstadoVentaDTO> estadoVentaList = new ArrayList<>();

        for (NotaVentaEntity notaVenta: notaVentaList
             ) {
            EstadoVentaDTO auxEstadoVenta = new EstadoVentaDTO();
            auxEstadoVenta.setEstadoVenta(notaVenta.getEstado());
            auxEstadoVenta.setNroNotaVenta(notaVenta.getId());
            auxEstadoVenta.setNombreCliente(notaVenta.getUser().getName());
            estadoVentaList.add(auxEstadoVenta);
        }

        return estadoVentaList;
    }

    public void updateEstado(UpdateEstadoDTO nuevoEstado) {
        NotaVentaEntity notaVenta = notaVentaRepository.findById(nuevoEstado.getNroNotaVenta()).orElse(null);
        notaVenta.setEstado(nuevoEstado.getNuevoEstado());
        notaVentaRepository.save(notaVenta);
    }
}
