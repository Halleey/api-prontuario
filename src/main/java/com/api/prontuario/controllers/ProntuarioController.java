package com.api.prontuario.controllers;

import com.api.prontuario.dtos.ProntuarioRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


public interface ProntuarioController {
    @PostMapping
    ResponseEntity<String> criarProntuario(@RequestHeader("Authorization") String token,@RequestBody ProntuarioRequestDTO dto);
}
