package com.proyectosi1.apirest.config.report;

import com.proyectosi1.apirest.model.dto.BitacoraQueryDTO;
import com.proyectosi1.apirest.model.dto.TableBitacoraDTO;
import com.proyectosi1.apirest.model.dto.TableParametersDTO;
import com.proyectosi1.apirest.model.entity.BitacoraEntity;
import com.proyectosi1.apirest.model.entity.DetalleVentaEntity;
import com.proyectosi1.apirest.model.entity.NotaVentaEntity;
import com.proyectosi1.apirest.model.entity.UserEntity;
import com.proyectosi1.apirest.model.repository.BitacoraRepository;
import com.proyectosi1.apirest.model.repository.DetalleVentaRepository;
import com.proyectosi1.apirest.model.repository.NotaVentaRepository;
import com.proyectosi1.apirest.model.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReportService {

    @Autowired
    private final NotaVentaRepository notaVentaRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final DetalleVentaRepository detalleVentaRepository;
    @Autowired
    private final BitacoraRepository bitacoraRepository;
    @Autowired
    private ResourceLoader resourceLoader;

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
        Resource resource = resourceLoader.getResource("classpath:NotaVenta.jasper");

        // Verificar si la nota de venta existe
        try {
            File file = resource.getFile();
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


    @NonNull
    public ResponseEntity<Resource> exportReportBitacora(BitacoraQueryDTO bitacoraQueryDTO){
        try {
            byte [] report = reportBitacora(bitacoraQueryDTO);
            String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
            StringBuilder stringBuilder = new StringBuilder();
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(stringBuilder
                        .append("Bitacora: ")
                        .append(sdf)
                        .append(".pdf")
                        .toString())
                .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);

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

    public byte[] reportBitacora(BitacoraQueryDTO bitacoraQueryDTO) {
        String usuario = bitacoraQueryDTO.getUsuario();
        Iterable<TableBitacoraDTO> tableBitacora = tableBitacora(bitacoraQueryDTO);
        Resource resource = resourceLoader.getResource("classpath:Bitacora.jasper");

        try {
            File file = resource.getFile();
            File imgLogo = ResourceUtils.getFile("classpath:images/logo.png");
            final JasperReport report = (JasperReport) JRLoader.loadObject(file);

            final HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("alterImage", new FileInputStream(imgLogo));
            parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>) tableBitacora));
            parameters.put("nombreEncargado", usuario != null ? usuario: "------");

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public List<TableBitacoraDTO> tableBitacora(BitacoraQueryDTO bitacoraQueryDTO) {
        List<TableBitacoraDTO> tableBitacoraDTOs = new ArrayList<>();
        Date fechaInicio = bitacoraQueryDTO.getFechaInicio();
        Date fechaFin = bitacoraQueryDTO.getFechaFin();
        Iterable<BitacoraEntity> bitacoraEntities = bitacoraRepository.findByFechaBetween(fechaInicio, fechaFin);

        bitacoraEntities.forEach(bitacoraEntity -> {
            TableBitacoraDTO tableBitacoraDTO = new TableBitacoraDTO();
            tableBitacoraDTO.setId(bitacoraEntity.getId());
            tableBitacoraDTO.setUser(bitacoraEntity.getUser().getName());
            tableBitacoraDTO.setAccion(bitacoraEntity.getAccion());

            Date fecha = bitacoraEntity.getFecha();

            // Crea un formato para la fecha que incluya horas, minutos y segundos
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");

            tableBitacoraDTO.setFecha(sdf.format(fecha));
            tableBitacoraDTO.setHora(sdfH.format(fecha));

            tableBitacoraDTOs.add(tableBitacoraDTO);
        });
        System.out.println(tableBitacoraDTOs);
        return tableBitacoraDTOs;
    }

}
