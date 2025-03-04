package com.api.prontuario.repositories;

import com.api.prontuario.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctors, UUID> {
    Optional<Doctors> findByName(String name);
}
