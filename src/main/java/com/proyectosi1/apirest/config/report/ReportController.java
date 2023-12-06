package com.proyectosi1.apirest.config.report;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectosi1.apirest.model.dto.BitacoraQueryDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales-note")
    public ResponseEntity<Resource> exportSalesNoteReport(@RequestParam Integer idNotaVenta) {
        return reportService.exportReportNoteSale(idNotaVenta);
    }

    @GetMapping("/bitacora-report")
    public ResponseEntity<Resource> exportBitacoraReport(@RequestBody BitacoraQueryDTO bitacoraQueryDTO) {
        return reportService.exportReportBitacora(bitacoraQueryDTO);
    }

}
