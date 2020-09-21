package com.proyecto.fabrica.consumeAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class NetClientGet {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080/restpedidos/");//your url i.e fetch data from .
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
                System.out.println(output);
                salida = output;
            }
            
            
            
            JSONArray json = new JSONArray(salida);
            System.out.println(json.toString());
            for (int i = 0; i < json.length(); i++) {
                JSONObject mio = json.getJSONObject(i);
                System.out.println("identificador ->" +mio.getString("url"));
                
            }
            
            conn.disconnect();
            
            
            

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}