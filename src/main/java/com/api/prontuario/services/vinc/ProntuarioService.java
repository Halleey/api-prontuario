package com.api.prontuario.services.vinc;

import com.api.prontuario.dtos.ProntuarioRequestDTO;
import com.api.prontuario.entities.Prontuario;

import java.util.List;

public interface ProntuarioService {

    void saveProntuario(String token, ProntuarioRequestDTO prontuarioRequestDTO);

    List<Prontuario> getProntuario(String patientCpf);
}


