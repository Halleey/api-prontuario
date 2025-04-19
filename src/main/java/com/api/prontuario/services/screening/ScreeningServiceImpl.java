package com.api.prontuario.services.screening;

import com.api.prontuario.config.jwt.JwtUtil;
import com.api.prontuario.dtos.ScreeningRequestDTO;
import com.api.prontuario.dtos.ScreeningResponseDTO;
import com.api.prontuario.entities.Screening;
import com.api.prontuario.repositories.PatientRepository;
import com.api.prontuario.repositories.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ScreeningServiceImpl implements ScreeningService{

    private final ScreeningRepository repository;
    private final JwtUtil jwtUtil;
    private final PatientRepository patientRepository;
    public ScreeningServiceImpl(ScreeningRepository repository, JwtUtil jwtUtil, PatientRepository patientRepository) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.patientRepository = patientRepository;
    }

    @Override
    public void generateScreening(String token, ScreeningRequestDTO requestDTO) {

        String registrationNumber = jwtUtil.getClaims(token).get("registrationNumber", String.class);

        if(!patientRepository.existsByCpf(requestDTO.getCpfPatient())) {
            throw new RuntimeException("Patient not exist in system");
        }
        Screening screening = new Screening();
        screening.setRegistrationNumber(registrationNumber);
        screening.setCpfPatient(requestDTO.getCpfPatient());
        screening.setPressaoArterialSistolica(requestDTO.getPressaoArterialSistolica());
        screening.setPressaoArterialDiastolica(requestDTO.getPressaoArterialDiastolica());
        screening.setTemperatura(requestDTO.getTemperatura());
        screening.setFrequenciaCardiaca(requestDTO.getFrequenciaCardiaca());
        screening.setSaturacaoOxigenio(requestDTO.getSaturacaoOxigenio());
        screening.setDateTime(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime());
        repository.save(screening);
    }

    @Override
    public List<ScreeningResponseDTO> getAllScreeningByCpf(String cpf, LocalDate localDate) {
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.atTime(LocalTime.MAX);

        List<Screening> screenings = repository.findByCpfAndDate(cpf, start, end);

        return screenings.stream().map(screening -> {
            ScreeningResponseDTO dto = new ScreeningResponseDTO();
            dto.setCpfPatient(screening.getCpfPatient());
            dto.setPressaoArterialSistolica(screening.getPressaoArterialSistolica());
            dto.setPressaoArterialDiastolica(screening.getPressaoArterialDiastolica());
            dto.setTemperatura(screening.getTemperatura());
            dto.setFrequenciaCardiaca(screening.getFrequenciaCardiaca());
            dto.setSaturacaoOxigenio(screening.getSaturacaoOxigenio());
            return dto;
        }).collect(Collectors.toList());
    }
}
