package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IClienteService;
import com.proyecto.fabrica.modelo.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IClienteService service;

    @GetMapping("/listar")
    public String listar(Model model)
    {
        List<Clientes>clientes=service.listar();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/new")
    public String agregar(Model modelo){
        modelo.addAttribute("clientes", new Clientes());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Clientes c, Model model){
        service.save(c);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Clientes>clientes=service.listarId(id);
        modelo.addAttribute("clientes", clientes);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/listar";
    }
}
