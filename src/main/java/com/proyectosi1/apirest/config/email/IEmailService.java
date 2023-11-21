package com.proyectosi1.apirest.config.email;

import java.io.File;

public interface IEmailService {

    void sendEmailWithMessage(String[] toUserEmails, String subject, String message);

    void sendEmailWithFile(String[] toUserEmails, String subject, String message, File file);

    void sendEmailWithReport(Integer idNotaVenta);
}
