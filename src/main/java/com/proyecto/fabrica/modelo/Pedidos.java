package com.proyecto.fabrica.modelo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "pedidos")
public class Pedidos {

    @Id
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_recibido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_entrega;
    private String estado;
    private ArrayList<String> repuestos;
    private String clientes;
    private int precio_final;
    private int cantidad;
    private String idventas;
    private int visto;

    public Pedidos () {

    }
    public Pedidos (Date fecha_recibido, Date fecha_entrega, String estado, ArrayList<String> repuestos, String clientes, int precio_final)
    {
        this.fecha_entrega = fecha_entrega;
        this.fecha_recibido = fecha_recibido;
        this.estado = estado;
        this.repuestos = repuestos;
        this.clientes = clientes;
        this.precio_final = precio_final;
        this.idventas = "";
        this.visto = 0;
    }

    @Autowired
    Productos productos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha_recibido() {
        return fecha_recibido;
    }

    public void setFecha_recibido(Date fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getRepuestos() {

        return repuestos;
    }

    public void setRepuestos(ArrayList<String> repuestos) {
        this.repuestos = repuestos;

    }

    public String getClientes() {

        return clientes;
    }

    public void setClientes(String clientes) {

        this.clientes = clientes;
    }

    public int getPrecio_final() {

        return precio_final;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }
    public int getVisto() {

        return this.visto;
    }

    public void setVisto(int visto) {

        this.visto = visto;
    }

    public void setPrecio_final(int precio_final) {

        this.precio_final = precio_final;
    }

    @Override
    public String toString()
    {
        return "pedidos [id = "+ id +", fecha_recibido="+ fecha_recibido +", fecha_entrega="+ fecha_entrega +", estado="+ estado +", repuestos="+ repuestos +", clientes="+ clientes +", precio_final="+ precio_final +", cantidad =" + cantidad +"]";

    }


    public String getIdventas() {
        return idventas;
    }

    public void setIdventas(String idventas) {
        this.idventas = idventas;
    }
}
