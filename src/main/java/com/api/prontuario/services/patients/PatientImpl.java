package com.api.prontuario.services.patients;

import com.api.prontuario.dtos.PatientDTO;
import com.api.prontuario.entities.Patient;
import com.api.prontuario.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void savePatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setNumber(patientDTO.getNumber());
        patient.setCpf(patientDTO.getCpf());
        patientRepository.save(patient);

    }
}
