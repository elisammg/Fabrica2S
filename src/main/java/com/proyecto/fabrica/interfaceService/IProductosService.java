package com.proyecto.fabrica.interfaceService;

import com.proyecto.fabrica.modelo.Productos;

import java.util.List;
import java.util.Optional;

public interface IProductosService {
    public List<Productos> listar();
    public Optional<Productos> listarId(String id);
    public int save(Productos p);
    public void delete(String id);
}
