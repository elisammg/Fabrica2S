package com.proyecto.fabrica.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Productos {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private String carros;
    private int precio;
    private String imagenurl;


    public Productos () {

    }
    public Productos(String nombre, String descripcion, String carros, int precio, String imagenurl)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.carros = carros;
        this.precio = precio;
        this.imagenurl = imagenurl;
        ///consultado 
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCarros() {
        return carros;
    }

    public void setCarros(String carros) {
        this.carros = carros;
    }


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }
}
