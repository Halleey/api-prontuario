package com.api.prontuario.controllers.screenings;

import com.api.prontuario.dtos.ScreeningRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ScreeningController {

    @PostMapping
    ResponseEntity<String> genereratedScreening(@RequestHeader("Authorization") String token, @RequestBody ScreeningRequestDTO requestDTO);

}