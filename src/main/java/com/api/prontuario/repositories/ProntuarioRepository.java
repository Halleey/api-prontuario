package com.api.prontuario.repositories;

import com.api.prontuario.entities.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProntuarioRepository extends JpaRepository<Prontuario, UUID> {
    List<Prontuario> findByPatientCpf(String patientCpf);


}
