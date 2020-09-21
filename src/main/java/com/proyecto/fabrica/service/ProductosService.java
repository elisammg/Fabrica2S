package com.proyecto.fabrica.service;

import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.interfaces.IProductos;
import com.proyecto.fabrica.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService implements IProductosService {
    @Autowired
    private IProductos data;

    @Override
    public List<Productos> listar() {
        return (List<Productos>) data.findAll();
    }

    @Override
    public Optional<Productos> listarId(String id) {
        return data.findById(id);
    }

    @Override
    public int save(Productos p) {
        int res=0;
        Productos productos=data.save(p);
        if (productos.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(String id) {
        data.deleteById(id);
    }
}
