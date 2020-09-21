package com.proyecto.fabrica.interfaceService;

import com.proyecto.fabrica.modelo.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Clientes>listar();
    public Optional<Clientes>listarId(String id);
    public int save(Clientes c);
    public void delete(String id);
}
