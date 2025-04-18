package com.api.prontuario.controllers.prontuarios;

import com.api.prontuario.dtos.ProntuarioRequestDTO;
import com.api.prontuario.entities.Prontuario;
import com.api.prontuario.services.vinc.ProntuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioControllerImpl implements ProntuarioController {

    private final ProntuarioService prontuarioService;

    public ProntuarioControllerImpl(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @Override
    public ResponseEntity<String> criarProntuario(String token, ProntuarioRequestDTO dto) {
        prontuarioService.saveProntuario(token.replace("Bearer ", ""), dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("✅ Prontuário criado com sucesso!");
    }

    @Override
    public ResponseEntity<List<Prontuario>> getProntuario(String patientCpf) {
        List<Prontuario> prontuarios = prontuarioService.getProntuario(patientCpf);
        if (prontuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prontuarios);
    }


}