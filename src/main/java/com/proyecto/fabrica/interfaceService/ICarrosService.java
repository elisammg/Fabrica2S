package com.proyecto.fabrica.interfaceService;


import com.proyecto.fabrica.modelo.Carros;

import java.util.List;
import java.util.Optional;

public interface ICarrosService {
    public List<Carros> listar();
    public Optional<Carros> listarId(String id);
    public int save(Carros ca);
    public void delete(String id);
}
