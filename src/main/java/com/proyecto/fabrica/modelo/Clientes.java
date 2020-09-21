package com.proyecto.fabrica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.text.DateFormat;

@Document(collection = "clientes")
public class Clientes {
    @Id
    private String id;

    private String nombre;
    private String direccion;
    private String telefono;
    private int entrega;
    private String password;

    public Clientes () {

        }
        public Clientes(String nombre, String direccion, String telefono, int entrega, String password)
        {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
            this.entrega = entrega;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEntrega() {
        return entrega;
    }

    public void setEntrega(int entrega) {
        this.entrega = entrega;
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
        return "cliente [id = "+ id +", nombre="+ nombre +", direccion="+ direccion +", telefono="+ telefono +", entrega = "+ entrega +", password = "+ password +"]";
    }



}

