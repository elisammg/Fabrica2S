package com.proyecto.fabrica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    private String nombre;
    private String telefono;
    private String password;

    public Usuario () {

        }
        public Usuario(String nombre, String direccion, String telefono, int entrega, String password)
        {
            this.nombre = nombre;
            this.telefono = telefono;
            this.password = password;

        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "cliente [id = "+ id +", nombre="+ nombre +", telefono="+ telefono +", password = "+ password +"]";
    }
}

