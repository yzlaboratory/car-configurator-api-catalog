package com.yzlaboratory.api_catalog.controller;

import com.yzlaboratory.api_catalog.entity.Catalog;
import com.yzlaboratory.api_catalog.service.DynamoDbService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final DynamoDbService service;

    public CatalogController(DynamoDbService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public String status() {
        System.out.println("Status Controller called");
        return "<h1>Hello World, its me the Status Controller of your friend api-catalog</h1>";
    }


    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public Catalog items() {
        System.out.println("Items Controller called");
        return this.service.getColorsByModel("Astral X_2025");
    }
}