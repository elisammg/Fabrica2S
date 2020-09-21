package com.proyecto.fabrica;

import com.proyecto.fabrica.controller.GreetingController;
import com.proyecto.fabrica.service.GreetingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GreetingControllerUnitTest {

    private GreetingController controller;
    private GreetingService greetingService;

    @Before
    public void setUp() {
        greetingService = Mockito.mock(GreetingService.class);
        controller = new GreetingController(greetingService);
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() {
        Mockito.when(greetingService.helloWorld()).thenReturn("Saludos");
        ResponseEntity<String> httpResponse = controller.sayHello();

        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("Saludos", httpResponse.getBody());
    }

}