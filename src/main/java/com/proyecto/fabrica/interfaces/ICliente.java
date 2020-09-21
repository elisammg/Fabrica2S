package com.proyecto.fabrica.interfaces;

import com.proyecto.fabrica.modelo.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends CrudRepository<Clientes, String> {

}
