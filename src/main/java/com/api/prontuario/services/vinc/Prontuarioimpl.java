package com.api.prontuario.services.vinc;

import com.api.prontuario.config.jwt.JwtUtil;
import com.api.prontuario.dtos.PrescriptionRequestDTO;
import com.api.prontuario.dtos.ProntuarioRequestDTO;
import com.api.prontuario.entities.Prescription;
import com.api.prontuario.entities.Prontuario;
import com.api.prontuario.repositories.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        prontuario.setDiagnosis(prontuarioRequestDTO.diagnosis() );
        prontuario.setTreatment(prontuarioRequestDTO.treatment());
        prontuario.setObservations(prontuarioRequestDTO.observations());

        if (prontuarioRequestDTO.getRequestDTOS() != null && !prontuarioRequestDTO.getRequestDTOS().isEmpty()) {
            for (PrescriptionRequestDTO prescriptionDTO : prontuarioRequestDTO.getRequestDTOS()) {
                Prescription prescription = new Prescription();
                prescription.setProntuario(prontuario);  // seta a ligação
                prescription.setMedicationName(prescriptionDTO.getMedicationName());
                prescription.setDose(prescriptionDTO.getDose());
                prescription.setFrequency(prescriptionDTO.getFrequency());
                prescription.setDuration(prescriptionDTO.getDuration());
                prontuario.getPrescriptions().add(prescription);
            }
        }

        prontuarioRepository.save(prontuario);
    }

    @Override
    public List<Prontuario> getProntuario(String patientCpf) {
       return prontuarioRepository.findByPatientCpf(patientCpf);
    }


}
