package com.proyecto.fabrica.interfaceService;



import com.proyecto.fabrica.modelo.Pedidos;

import java.util.List;
import java.util.Optional;

public interface IPedidosService {
    public List<Pedidos> listar();
    public List<Pedidos> listardetalle();
    public Optional<Pedidos> listarId(String id);
    public int save(Pedidos pe);
    public void delete(String id);
}
