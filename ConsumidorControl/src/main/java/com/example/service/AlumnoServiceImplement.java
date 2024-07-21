/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import com.example.repository.AlumnoRepository;
import com.example.repository.EspecialidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AlumnoServiceImplement implements IAlumnoService{
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    
    @Override
    public List<Alumno> listarAlumnos() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public void guardar(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno buscarAlumnoPorID(int id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<Alumno> buscarAlumnosPorCursoYSeccion(int idespe, String curso, int seccion) {
        Especialidad especialidad = especialidadRepository.findById(idespe)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        return alumnoRepository.findByEspecialidadAndCursoAndSeccion(especialidad, curso, seccion);
    }
    
}
