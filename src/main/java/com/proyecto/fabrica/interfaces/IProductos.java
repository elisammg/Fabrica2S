package com.proyecto.fabrica.interfaces;

import com.proyecto.fabrica.modelo.Productos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductos extends CrudRepository<Productos, String> {
}
