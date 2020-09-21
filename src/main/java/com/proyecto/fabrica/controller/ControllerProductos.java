package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.ICarrosService;
import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.modelo.Carros;
import com.proyecto.fabrica.modelo.Productos;
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
public class ControllerProductos {

    @Autowired
    private IProductosService service;
    @Autowired
    private ICarrosService serviceCarros;

    @GetMapping("/productos")
    public String listar(Model model)
    {
        List<Productos> productos=service.listar();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/productonuevo")
    public String agregar(Model modelo){
        modelo.addAttribute("productos", new Productos());
        List<Carros> carros=serviceCarros.listar();
        modelo.addAttribute("lcarros", carros);
        return "productonuevo";
    }

    @PostMapping("/saveproducto")
    public String save(@Valid Productos p, Model model){
        service.save(p);
        return "redirect:/productos";
    }

    @GetMapping("/editarproducto/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Productos> productos=service.listarId(id);
        modelo.addAttribute("productos", productos);
        List<Carros> carros=serviceCarros.listar();
        modelo.addAttribute("lcarros", carros);
        return "productonuevo";
    }

    @GetMapping("/eliminarproducto/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/productos";
    }
}
