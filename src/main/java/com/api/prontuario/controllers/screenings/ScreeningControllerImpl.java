package com.api.prontuario.controllers.screenings;

import com.api.prontuario.dtos.ScreeningRequestDTO;
import com.api.prontuario.services.screening.ScreeningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/screening")
public class ScreeningControllerImpl implements ScreeningController{

    private final ScreeningService service;

    public ScreeningControllerImpl(ScreeningService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<String> genereratedScreening(String token, ScreeningRequestDTO requestDTO) {
        service.generateScreening(token.replace("Bearer ", ""), requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("✅ \n" +
                "Screening completed successfully!");
    }
}
