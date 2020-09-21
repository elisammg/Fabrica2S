package com.proyecto.fabrica.interfaces;

import com.proyecto.fabrica.modelo.Pedidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidos extends CrudRepository<Pedidos, String> {
}
