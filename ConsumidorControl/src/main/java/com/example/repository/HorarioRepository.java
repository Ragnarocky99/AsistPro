package com.example.repository;

import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.model.Sala;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    List<Horario> findByEspecialidad(Especialidad especialidad);
    @Query(value = "SELECT * FROM horario h WHERE h.id_sala = :id_sala AND h.hora_inicio <= :horaActual AND h.id_especialidad = :espe AND h.seccion = :seccion order by hora_inicio desc limit 1", nativeQuery = true )
    Horario findHariosDisponibles(@Param("id_sala") int id_sala, @Param("horaActual") LocalTime horaActual, @Param("espe") int especialidad, int seccion);
}
