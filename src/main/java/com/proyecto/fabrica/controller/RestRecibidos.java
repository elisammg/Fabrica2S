package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.modelo.Pedidos;
import com.proyecto.fabrica.modelo.Productos;
import com.proyecto.fabrica.modelo.Recibidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/envioapi")
public class RestRecibidos {


    @Autowired
    private IProductosService service;

    @Autowired
    private IPedidosService servicepedidos;

    /**
     *
     * @return
     */

    @GetMapping
    public ArrayList<Recibidos> listar(){
        ArrayList<Recibidos> res = new ArrayList<>();
        List<Pedidos> pedidosList = servicepedidos.listar();
        for (int i = 0; i < pedidosList.size(); i++){
            Pedidos pedido = pedidosList.get(i);
            Optional<Productos> productosOptional = service.listarId(pedido.getRepuestos().get(0));
            Recibidos re = new Recibidos(pedido, productosOptional.get());
            res.add(re);
        }
        return res;
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
