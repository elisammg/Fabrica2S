package com.proyecto.fabrica.interfaceService;

import com.proyecto.fabrica.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(String id);
    public int save(Usuario c);
    public void delete(String id);
}
