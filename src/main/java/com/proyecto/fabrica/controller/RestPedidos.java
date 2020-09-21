package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.modelo.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/pedidosapi")
public class RestPedidos {


    @Autowired
    private IPedidosService service;

    /**
     *
     * @return
     */

    @GetMapping
    public List<Pedidos> listar(){

        return service.listar();
    }

    /**
     *
     * @param pro
     */

    @PostMapping
    public void insertar(@RequestBody Pedidos pro){
        service.save(pro);
    }

    /**
     *
     * @param pro
     */

    @PutMapping
    public void modificar(Pedidos pro){
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
