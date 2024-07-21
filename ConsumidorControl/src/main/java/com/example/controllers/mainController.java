package com.example.controllers;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import com.example.service.IAlumnoService;
import com.example.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mainController {
    @Autowired
    private IEspecialidadService especialidadService;

    @Autowired
    private IAlumnoService alumnoService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Especialidad> especialidades = especialidadService.listarEspecialidades();
        model.addAttribute("especialidades", especialidades);
        return "indice";
    }
    
    @GetMapping("/verEspecialidad/{idEspe}")
    public String verEspecialidad(@PathVariable("idEspe") int idEspe, Model model) {
        Especialidad especialidadSeleccionada = especialidadService.buscarEspecialidadPorId(idEspe);
        model.addAttribute("especialidad", especialidadSeleccionada);
        return "especialidades/verEspecialidad";
    }
    
    @GetMapping("/verEspecialidad/{idEspe}/alumnos")
    public String verAlumnos(@PathVariable("idEspe") int idEspe, 
                             @RequestParam("curso") String curso, 
                             @RequestParam("seccion") int seccion, 
                             Model model) {
        List<Alumno> alumnos = alumnoService.buscarAlumnosPorCursoYSeccion(idEspe, curso, seccion);
        Especialidad especialidadSeleccionada = especialidadService.buscarEspecialidadPorId(idEspe);
        model.addAttribute("especialidad", especialidadSeleccionada);
        model.addAttribute("alumnos", alumnos);
        return "especialidades/verEspecialidad";
    }
    
    @GetMapping("/verFormularios")
    public String verFormularios() {
        return "verFormularios";
    }
}
