package com.proyecto.fabrica;

import com.proyecto.fabrica.service.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class GreetingServiceUnitTest {

    private GreetingService greetingService = new GreetingService();

    @Test
    @DisplayName(value = "Prueba uno test unitario")
    public void itShouldSayHolaMundo() {

        Assert.assertEquals("Hola", greetingService.helloWorld());
        System.out.println("Test Exitoso");
    }

    @Test
    @DisplayName(value = "Prueba dos test unitario")
    public void itShouldSayHolaPlaneta() {

        Assert.assertEquals("Hola Planeta", greetingService.holaplaneta());
    }

}
