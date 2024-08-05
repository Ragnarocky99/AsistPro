package com.example.repository;

import com.example.model.Especialidad;
import com.example.model.Horario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    List<Horario> findByEspecialidad(Especialidad especialidad);
}
