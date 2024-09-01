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
    
    @Query("SELECT a FROM Alumno a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    List<Alumno> findByNombre(String nombre);
    
    @Query(value = "SELECT * FROM alumno a where a.id_especialidad = :idEspe and a.curso = :curso and a.seccion = :seccion and a.estado = 'activo'", nativeQuery = true)
    List<Alumno> findByEspecialidadAndCursoAndSeccion(
            @Param("idEspe")int especialidad, 
            @Param("curso") String curso, 
            @Param("seccion")int seccion);
    
    List<Alumno> findByEspecialidadAndCursoAndSeccionAndEstado(Especialidad especialidad, String curso, int seccion, String estado);
    List<Alumno> findAlumnosByEstado(String estado);
    
    
}

