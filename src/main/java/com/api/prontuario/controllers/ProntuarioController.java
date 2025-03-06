package com.api.prontuario.controllers;

import com.api.prontuario.dtos.ProntuarioRequestDTO;
import com.api.prontuario.entities.Prontuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface ProntuarioController {
    @PostMapping
    ResponseEntity<String> criarProntuario(@RequestHeader("Authorization") String token, @RequestBody ProntuarioRequestDTO dto);

    @GetMapping
    ResponseEntity<List<Prontuario>> getProntuario(@RequestParam("patientCpf") String patientCpf);
}
