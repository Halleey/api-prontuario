package com.api.prontuario.controllers.screenings;

import com.api.prontuario.dtos.ScreeningRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface ScreeningController {

    @PostMapping
    ResponseEntity<String> genereratedScreening(@RequestHeader("Authorization") String token, @RequestBody ScreeningRequestDTO requestDTO);
}
