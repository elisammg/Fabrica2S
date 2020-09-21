package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.ICarrosService;
import com.proyecto.fabrica.modelo.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/carroapi")
public class RestCarros {


    @Autowired
    private ICarrosService service;

    /**
     *
     * @return
     */

    @GetMapping
    public List<Carros> listar(){
        return service.listar();
    }

    /**
     *
     * @param pro
     */

    @PostMapping
    public void insertar(@RequestBody Carros pro){
        service.save(pro);
    }

    /**
     *
     * @param pro
     */

    @PutMapping
    public void modificar(Carros pro){
        service.save(pro);
    }

    /**
     *
     * @param id
     */

    @DeleteMapping(value = "/{id}")
    public void eliminar (@PathVariable("id") String id){
        service.delete(id);
    }
}
