package com.example.service;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import java.util.List;
import org.springframework.stereotype.Service;


public interface IAlumnoService {
    
    List<Alumno> listarAlumnos();
    void guardar(Alumno alumno);
    Alumno buscarAlumnoPorID(int id);
    void eliminar(int id);
    List<Alumno> buscarAlumnosPorCursoYSeccion(int idespe, String curso, int seccion);
    
    
}
