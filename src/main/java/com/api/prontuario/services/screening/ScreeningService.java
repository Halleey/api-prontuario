package com.api.prontuario.services.screening;

import com.api.prontuario.dtos.ScreeningRequestDTO;

public interface ScreeningService {


    void generateScreening(String token, ScreeningRequestDTO requestDTO);
}
