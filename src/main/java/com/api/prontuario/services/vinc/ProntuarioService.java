package com.api.prontuario.services.vinc;

import com.api.prontuario.dtos.ProntuarioRequestDTO;

public interface ProntuarioService {

    public void saveProntuario(String token, ProntuarioRequestDTO prontuarioRequestDTO);
}


