package com.example.repository;

import com.example.model.Asistencia;
import com.example.model.Horario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    Asistencia findByFechaAndHorario(LocalDate fecha, Horario horario);
    
    // Consulta personalizada para obtener asistencias por fecha, especialidad, curso y sección
    @Query("SELECT a FROM Asistencia a " +
           "JOIN DetalleAsistencia da ON a.id = da.asistencia.id " +
           "JOIN da.alumno al " +
           "WHERE a.fecha = :fecha " +
           "AND al.especialidad.id = :especialidadId " +
           "AND al.curso = :curso " +
           "AND al.seccion = :seccion")
    List<Asistencia> findAsistenciasByFechaEspecialidadCursoSeccion(
        @Param("fecha") LocalDate fecha,
        @Param("especialidadId") Integer especialidadId,
        @Param("curso") String curso,
        @Param("seccion") int seccion);
    
}

