package com.proyecto.fabrica.interfaces;


import com.proyecto.fabrica.modelo.Carros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarros extends CrudRepository <Carros, String> {
}
