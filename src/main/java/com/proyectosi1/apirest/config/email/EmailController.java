package com.proyectosi1.apirest.config.email;

import com.proyectosi1.apirest.model.dto.EmailFileDTO;
import com.proyectosi1.apirest.model.dto.EmailMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/send-email")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/message")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailMessageDTO emailDTO) {
        emailService.sendEmailWithMessage(emailDTO.getToUser(), emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/message-file")
    public ResponseEntity<?> receiveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO) {
        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/main/resources/files/" + fileName);

            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();

            emailService.sendEmailWithFile(emailFileDTO.getToUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);

            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");
            response.put("archivo", fileName);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el Email con el archivo. " + e.getMessage());
        }
    }

    @PostMapping("/reporte-nota-venta")
    public ResponseEntity<?> receiveRequestEmailWithFile(@RequestParam Integer idNotaVenta) {
        try {
            emailService.sendEmailWithReport(idNotaVenta);

            Map<String, String> response = new HashMap<>();
            response.put("estado", "Enviado");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el Email con el archivo. " + e.getMessage());
        }
    }

}
