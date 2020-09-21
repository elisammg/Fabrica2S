package com.proyecto.fabrica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/excel")
    public String home() {
        return "home";
    }
}