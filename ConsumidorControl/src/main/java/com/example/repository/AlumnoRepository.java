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
    List<Alumno> findByEspecialidadAndCursoAndSeccionAndEstado(Especialidad especialidad, String curso, int seccion, String estado);
    
    @Query("SELECT a FROM Alumno a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    List<Alumno> findByNombre(String nombre);
    
    @Query(value = "SELECT * FROM alumno a where id_especialidad = :idEspe and curso = :curso and seccion = :seccion and estado = 'activo'", nativeQuery = true)
    List<Alumno> findByEspecialidadAndCursoAndSeccion(
            @Param("idEspe")int especialidad, 
            @Param("curso") String curso, 
            @Param("seccion")int seccion);
    
    
    
    
        // Custom query to find students by course, section, specialty, and date of attendance
    
}

