package com.api.prontuario.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiTest {

    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok().body("Ping está funcionando");

    }

}
