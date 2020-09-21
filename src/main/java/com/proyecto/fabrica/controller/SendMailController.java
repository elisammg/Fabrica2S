package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.modelo.Pedidos;
import com.proyecto.fabrica.service.SendMailService;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class SendMailController {

    @Autowired
    private SendMailService mailService;
    @Autowired
    private IPedidosService service;

    @GetMapping("/sendmail")
    public String index(){
        return "sendmail";
    }

    @PostMapping("/mailsend")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) throws IOException, MessagingException{
        List<Pedidos> listaPedidos = service.listar();
        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendMail("elisamargarita.2899@gmail.com",mail,subject,message,listaPedidos);
        return "sendmail";
    }
}
