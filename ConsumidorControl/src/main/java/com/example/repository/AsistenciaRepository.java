package com.example.repository;

import com.example.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    
}
