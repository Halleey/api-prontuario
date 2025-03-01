package com.api.prontuario.repositories;

import com.api.prontuario.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctors, UUID> {
    
}
