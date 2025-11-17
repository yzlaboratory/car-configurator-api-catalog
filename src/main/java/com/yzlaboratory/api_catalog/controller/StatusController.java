package com.yzlaboratory.api_catalog.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.yzlaboratory.api_catalog.service.DynamoDbService;
import jdk.jshell.Snippet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalog")
public class StatusController {

    private final DynamoDbService service;

    public StatusController(DynamoDbService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public String status() {
        System.out.println("Status Controller called");
        return "<h1>Hello World, its me the Status Controller of your friend api-catalog</h1>";
    }

    @GetMapping("/items")
    public String items() {
        System.out.println("Items Controller called");
        return service.getColorsByModel("Astral X");
    }
}