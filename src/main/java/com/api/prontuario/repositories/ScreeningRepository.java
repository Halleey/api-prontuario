package com.api.prontuario.repositories;

import com.api.prontuario.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<Screening, UUID> {
}
