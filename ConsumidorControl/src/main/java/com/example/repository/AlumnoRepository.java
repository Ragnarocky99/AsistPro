package com.example.repository;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByEspecialidadAndCursoAndSeccion(Especialidad especialidad, String curso, int seccion);
}

