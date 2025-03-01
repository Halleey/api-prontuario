package com.api.prontuario.listener;

import com.api.prontuario.dtos.DoctorDTO;
import com.api.prontuario.services.doctors.DoctorsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class DoctorListener {

    private final DoctorsService service;

    public DoctorListener(DoctorsService service) {
        this.service = service;
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "Hospital", partitions = {"1"}),
            groupId = "prontuario-group"
    )
        public void saveDoctor(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DoctorDTO doctorDTO = mapper.readValue(message, DoctorDTO.class);
            service.saveDoctor(doctorDTO);
        }
        catch (Exception e) {
            System.err.println("Erro ao converter JSON: " + e.getMessage());
        }
    }
}