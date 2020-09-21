package com.proyecto.fabrica.service;


import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.interfaces.IPedidos;
import com.proyecto.fabrica.modelo.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService implements IPedidosService {

    @Autowired
    private IPedidos data;


    @Override
    public List<Pedidos> listar() {

        return (List<Pedidos>) data.findAll();
    }

    @Override
    public List<Pedidos> listardetalle() {
        return (List<Pedidos>) data.findAll();

    }

    @Override
    public Optional<Pedidos> listarId(String id) {
        return data.findById(id);
    }

    @Override
    public int save(Pedidos pe) {
        int res=0;
        Pedidos pedidos=data.save(pe);
        if (pedidos.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(String id) {

        data.deleteById(id);
    }
}
