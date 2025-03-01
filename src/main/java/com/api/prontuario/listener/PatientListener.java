package com.api.prontuario.listener;

import com.api.prontuario.dtos.PatientDTO;
import com.api.prontuario.services.PatientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientListener {
    private final PatientImpl patientS;

    public PatientListener(PatientImpl patientS) {
        this.patientS = patientS;
    }

    @KafkaListener(topics = "Hospital", groupId = "prontuario-group")
    public void consumePatient(String message) {
        System.out.println("Mensagem recebida: " + message);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PatientDTO patient = objectMapper.readValue(message, PatientDTO.class);
            System.out.println("Paciente convertido: " + patient.getName());
            patientS.savePatient(patient);
        } catch (Exception e) {
            System.err.println("Erro ao converter JSON: " + e.getMessage());
        }
    }
}
