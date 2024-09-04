package com.example.repository;

import com.example.model.Especialidad;
import com.example.model.Horario;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    List<Horario> findByEspecialidad(Especialidad especialidad);

    @Query(value = "SELECT * FROM horario h WHERE h.id_sala = :id_sala AND h.hora_inicio <= :horaActual AND h.id_especialidad = :espe AND h.seccion = :seccion AND h.dias LIKE %:diaSemana% order by hora_inicio desc limit 1", nativeQuery = true)
    Horario findHorariosDisponibles(@Param("id_sala") int id_sala, @Param("horaActual") LocalTime horaActual, @Param("espe") int especialidad, int seccion, @Param("diaSemana") String diaSemana);

    @Query(value = "SELECT * FROM horario h "
            + "WHERE h.id_sala = :id_sala "
            + "AND :horaActual BETWEEN h.hora_inicio AND h.hora_fin "
            + "AND h.id_especialidad = :especialidad "
            + "AND h.curso = :curso "
            + "AND h.seccion = :seccion "
            + "AND h.dias LIKE %:diaSemana% "
            + "ORDER BY h.hora_inicio DESC "
            + "LIMIT 1", nativeQuery = true)
    Horario findHorarioDisponible(@Param("id_sala") int idSala,
            @Param("horaActual") LocalTime horaActual,
            @Param("especialidad") int especialidad,
            @Param("curso") String curso,
            @Param("seccion") int seccion,
            @Param("diaSemana") String diaSemana);

}
