package com.proyecto.fabrica.interfaces;

import com.proyecto.fabrica.modelo.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario, String> {
    /*@Query(value = "{'employees.name': ?0}", fields = "{'employees' : 0}")
    Usuario findDepartmentByEmployeeName(String empName);
    List findDepartmentByName(String name); //*/
}
