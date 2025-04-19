package com.api.prontuario.repositories;

import com.api.prontuario.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<Screening, UUID> {

    @Query("SELECT s FROM Screening s WHERE s.cpfPatient = :cpf AND s.dateTime BETWEEN :start AND :end")
    List<Screening> findByCpfAndDate(@Param("cpf") String cpf,
                                     @Param("start") LocalDateTime start,
                                     @Param("end") LocalDateTime end);
}
