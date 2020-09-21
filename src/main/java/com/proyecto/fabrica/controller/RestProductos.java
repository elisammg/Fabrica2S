package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/rtproductos")
public class RestProductos {


    @Autowired
    private IProductosService service;

    /**
     *
     * @return
     */

    @GetMapping
    public List<Productos> listar(){
        return service.listar();
    }

    /**
     *
     * @param pro
     */

    @PostMapping
    public void insertar(@RequestBody Productos pro){
        service.save(pro);
    }

    /**
     *
     * @param pro
     */

    @PutMapping
    public void modificar(Productos pro){
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
