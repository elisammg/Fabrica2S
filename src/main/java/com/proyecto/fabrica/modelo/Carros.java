package com.proyecto.fabrica.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="carros")
public class Carros {
    /**
     *
     *
     */

    @Id
    private String id;
    /**
     *
     */
    private int codigo_universal;
    private String marca;
    private String linea;
    private int modelo;

    /**
     *
     */
    public Carros()
    {

    }

    /**
     *
     * @param codigo_universal
     * @param marca
     * @param linea
     * @param modelo
     */

    public Carros(int codigo_universal, String marca, String linea, int modelo)
    {
        this.codigo_universal = codigo_universal;
        this.marca = marca;
        this.linea = linea;
        this.modelo=modelo;

    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getCodigo_universal() {
        return codigo_universal;
    }

    /**
     *
     * @param codigo_universal
     */
    public void setCodigo_universal(int codigo_universal) {
        this.codigo_universal = codigo_universal;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     *
     * @return
     */
    public int getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "carro [id = "+ id +", codigo_universal="+ codigo_universal +", marca="+ marca +", linea="+ linea +", modelo="+ modelo +"]";
    }
}
