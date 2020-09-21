package com.proyecto.fabrica.service;
import com.proyecto.fabrica.interfaceService.IUsuarioService;
import com.proyecto.fabrica.interfaces.IUsuario;
import com.proyecto.fabrica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuarioService {

    @Autowired
    private IUsuario data;
    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) data.findAll();
    }

    @Override
    public Optional<Usuario> listarId(String id) {

        return data.findById(id);
    }

    @Override
    public int save(Usuario c) {
        return data.save(c)==null?1:0;
    }

    @Override
    public void delete(String id) {
        data.deleteById(id);
    }
}
