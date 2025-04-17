package com.api.prontuario.repositories;

import com.api.prontuario.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findByCpf(String cpf);

    boolean existsByCpf(String patientCpf);
}
