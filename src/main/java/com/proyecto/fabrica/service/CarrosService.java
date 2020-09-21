package com.proyecto.fabrica.service;


import com.proyecto.fabrica.interfaceService.ICarrosService;
import com.proyecto.fabrica.interfaces.ICarros;
import com.proyecto.fabrica.modelo.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrosService implements ICarrosService {

    @Autowired
    private ICarros data;

    @Override
    public List<Carros> listar() {
        return (List<Carros>) data.findAll();
    }

    @Override
    public Optional<Carros> listarId(String id) {
        return data.findById(id);
    }

    @Override
    public int save(Carros ca) {
        int res=0;
        Carros carros=data.save(ca);
        if (carros.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(String id) {
        data.deleteById(id);
    }
}
