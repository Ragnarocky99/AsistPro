package com.example.repository;

import com.example.model.Asistencia;
import com.example.model.Horario;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    Asistencia findByFechaAndHorario(LocalDate fecha, Horario horario);
}
