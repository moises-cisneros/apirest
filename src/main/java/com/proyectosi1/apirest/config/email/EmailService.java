package com.proyectosi1.apirest.config.email;

import com.proyectosi1.apirest.service.NotaVentaService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmailService implements IEmailService {

    @Value("${email.sender}")
    private String email;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotaVentaService notaVentaService;

    // Envio de mensajes por correo
    @Override
    public void sendEmailWithMessage(String[] toUserEmails, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(email);
        simpleMailMessage.setTo(toUserEmails);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);
    }

    // Envio de mensaje y archivo por correo
    @Override
    public void sendEmailWithFile(String[] toUserEmails, String subject, String message, File file) {
        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(mimeMessage, toUserEmails, subject, message);
            mimeMessageHelper.addAttachment(file.getName(), file);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Envio de reporte de nota de venta por correo
    @Override
    public void sendEmailWithReport(Integer idNotaVenta) {
        try {

            String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());

            // Asignar los datos que iran en el correo
            String[] toUserEmails = new String[]{notaVentaService.getNotaVenta(idNotaVenta).getUser().getEmail()};
            String subject = "Compra de productos de la Tienda de ropa DapperMens";
            String message = "Nota de Venta Nro: 000" + idNotaVenta;
            byte[] reportBytes = notaVentaService.reportNoteSale(idNotaVenta);
            String fileName = ("NotaVenta_Nro_" + idNotaVenta + "_" + sdf + ".pdf");

            // Creación de un objeto MimeMessage para representar el correo electrónico
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(mimeMessage, toUserEmails, subject, message);

            mimeMessageHelper.addAttachment(fileName, new ByteArrayResource(reportBytes)); // Adjunta un archivo al correo electrónico

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Configuración de los detalles del correo electrónico
    private MimeMessageHelper getMimeMessageHelper(MimeMessage mimeMessage, String[] toUserEmails, String subject, String message) throws MessagingException {
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

        mimeMessageHelper.setFrom(email); // Establece la dirección de correo electrónico del remitente
        mimeMessageHelper.setTo(toUserEmails); // Establece las direcciones de correo electrónico de los destinatarios
        mimeMessageHelper.setSubject(subject); // Establece el asunto del correo electrónico
        mimeMessageHelper.setText(message); // Establece el cuerpo del correo electrónico

        return mimeMessageHelper;
    }

}
