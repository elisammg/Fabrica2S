package com.proyecto.fabrica.controller;


import com.proyecto.fabrica.interfaceService.IClienteService;
import com.proyecto.fabrica.modelo.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webservice")
public class RestDemoController {

    @Autowired
    private IClienteService service;

    @GetMapping
    public List<Clientes> listar(){
        return service.listar();
    }

    @PostMapping
    public void insertar(@RequestBody Clientes cli){
        service.save(cli);
    }

    @PutMapping
    public void modificar(Clientes cli){
        service.save(cli);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar (@PathVariable("id") String id){
        service.delete(id);
    }
}
