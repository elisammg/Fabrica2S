package com.proyecto.fabrica.controller;


import com.proyecto.fabrica.interfaceService.ICarrosService;
import com.proyecto.fabrica.modelo.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControllerCarros {

    @Autowired
    private ICarrosService service;

    @GetMapping("/carros")
    public String listar(Model model)
    {
        List<Carros> carros=service.listar();
        model.addAttribute("carros", carros);
        return "carros";
    }

    @GetMapping("/carronuevo")
    public String agregarcarro(Model modelo){
        modelo.addAttribute("carros", new Carros());
        return "carronuevo";
    }

    @PostMapping("/savecarro")
    public String save(@Valid Carros ca, Model model){
        service.save(ca);
        return "redirect:/carros";
    }

    @GetMapping("/editarcarro/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Carros> carros=service.listarId(id);
        modelo.addAttribute("carros", carros);
        return "carronuevo";
    }

    @GetMapping("/eliminarcarro/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/carros";
    }
}
