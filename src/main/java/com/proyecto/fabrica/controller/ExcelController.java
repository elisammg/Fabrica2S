package com.proyecto.fabrica.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.proyecto.fabrica.excel.ExcelGenerator;
import com.proyecto.fabrica.interfaces.IPedidos;
import com.proyecto.fabrica.modelo.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/customers")
public class ExcelController {
    @Autowired
    IPedidos iPedidos;

    @GetMapping(value = "/download/customers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Pedidos> customers = (List<Pedidos>) iPedidos.findAll();

        ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}