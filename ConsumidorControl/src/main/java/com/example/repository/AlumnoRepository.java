package com.example.repository;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByEspecialidadAndCursoAndSeccion(Especialidad especialidad, String curso, int seccion);
    
    @Query("SELECT a FROM Alumno a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    List<Alumno> findByNombre(String nombre);
    
        // Custom query to find students by course, section, specialty, and date of attendance
    
}

