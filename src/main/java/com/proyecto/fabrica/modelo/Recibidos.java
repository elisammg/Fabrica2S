package com.proyecto.fabrica.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "recibidos")
public class Recibidos {

    @Id
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_recibido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_entrega;
    private String estado;
    private String numero_de_parte;
    private String nombre_producto;
    private ArrayList<String> repuestos;
    private String clientes;
    private int precio_final;
    private int cantidad;
    private int precio_fabricante;
    private String vehiculo_compatible;
    private int visto;

    public Recibidos () {

    }



    public Recibidos (Pedidos pedidos, Productos productos)
    {
        this.id = pedidos.getId();
        this.fecha_entrega = pedidos.getFecha_entrega();
        this.fecha_recibido = pedidos.getFecha_recibido();
        this.estado = pedidos.getEstado();
        this.repuestos = pedidos.getRepuestos();
        this.clientes = pedidos.getClientes();
        this.cantidad = pedidos.getCantidad();
        this.precio_final = pedidos.getPrecio_final();
        this.numero_de_parte = productos.getId();
        this.nombre_producto = productos.getNombre();
        this.precio_fabricante = productos.getPrecio();
        this.vehiculo_compatible = productos.getCarros();
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

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getNumero_de_parte() {
        return numero_de_parte;
    }

    public void setNumero_de_parte(String numero_de_parte) {
        this.numero_de_parte = numero_de_parte;
    }

    public Productos getProductos() {
        return productos;
    }


    @Override
    public String toString()
    {
        return "pedidos [id = "+ id +", fecha_recibido="+ fecha_recibido +", fecha_entrega="+ fecha_entrega +", estado="+ estado +", repuestos="+ repuestos +", clientes="+ clientes +", precio_final="+ precio_final +", cantidad =" + cantidad +"]";

    }


    public int getPrecio_fabricante() {
        return precio_fabricante;
    }

    public void setPrecio_fabricante(int precio_fabricante) {
        this.precio_fabricante = precio_fabricante;
    }

    public String getVehiculo_compatible() {
        return vehiculo_compatible;
    }

    public void setVehiculo_compatible(String vehiculo_compatible) {
        this.vehiculo_compatible = vehiculo_compatible;
    }
}