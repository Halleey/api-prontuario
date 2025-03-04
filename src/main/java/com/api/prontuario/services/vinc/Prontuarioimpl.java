package com.api.prontuario.services.vinc;

import com.api.prontuario.config.jwt.JwtUtil;
import com.api.prontuario.dtos.ProntuarioRequestDTO;
import com.api.prontuario.entities.Prontuario;
import com.api.prontuario.repositories.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Prontuarioimpl implements  ProntuarioService {


    private final ProntuarioRepository prontuarioRepository;
    private final JwtUtil jwtUtil;

    public Prontuarioimpl(ProntuarioRepository prontuarioRepository, JwtUtil jwtUtil) {
        this.prontuarioRepository = prontuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void saveProntuario(String token, ProntuarioRequestDTO prontuarioRequestDTO) {
        String doctorCrm = jwtUtil.getClaims(token).get("crm", String.class);

        Prontuario prontuario = new Prontuario();
        prontuario.setDoctorCrm(doctorCrm);
        prontuario.setPatientCpf(prontuarioRequestDTO.patientCpf());
        prontuario.setConsultationDate(LocalDateTime.now());
        prontuario.setDiagnosis(prontuarioRequestDTO.diagnosis());
        prontuario.setTreatment(prontuarioRequestDTO.treatment());
        prontuario.setObservations(prontuarioRequestDTO.observations());
        prontuarioRepository.save(prontuario);

    }
}
