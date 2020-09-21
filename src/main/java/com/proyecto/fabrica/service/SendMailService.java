package com.proyecto.fabrica.service;

import com.proyecto.fabrica.excel.ExcelGenerator;
import com.proyecto.fabrica.modelo.Pedidos;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {



    @Autowired
    private JavaMailSender javaMailSender;



    public void sendMail(String from, String to, String subject, String body,List<Pedidos> pedidos) throws IOException, MessagingException {
        
        MimeMessage message = javaMailSender.createMimeMessage();

        ByteArrayInputStream in = ExcelGenerator.customersToExcel(pedidos);
        
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            helper.addAttachment("Pedidos.xlsx", new ByteArrayResource(in.readAllBytes()));
            javaMailSender.send(message);
        } catch (MessagingException e) {

        }


    }


}