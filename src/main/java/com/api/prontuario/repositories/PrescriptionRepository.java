package com.api.prontuario.repositories;
import com.api.prontuario.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface PrescriptionRepository extends JpaRepository<Prescription, UUID> {
}
