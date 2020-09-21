/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.fabrica.consumeAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author elisa
 */
public class NetCliente {
    
    public String MetodoGet(String urlApi){
        try {

            URL url = new URL(urlApi);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            String salida = "";
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                salida += output;
            }
            conn.disconnect();
            
            return salida;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return "";
    }
}
