package com.proyecto.fabrica.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String helloWorld() {
        return"Hola Mundo";
    }

    public String holaplaneta() {

        return"Hola Planeta";
    }

}