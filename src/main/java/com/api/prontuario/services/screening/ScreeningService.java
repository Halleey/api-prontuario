package com.api.prontuario.services.screening;

import com.api.prontuario.dtos.ScreeningRequestDTO;
import com.api.prontuario.dtos.ScreeningResponseDTO;

import java.time.LocalDate;
import java.util.List;


public interface ScreeningService {


    void generateScreening(String token, ScreeningRequestDTO requestDTO);

    List<ScreeningResponseDTO> getAllScreeningByCpf(String cpf, LocalDate localDate);

}
