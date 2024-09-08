package com.example.controllers;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import com.example.service.IAlumnoService;
import com.example.service.IEspecialidadService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
        model.addAttribute("especialidadesColores", Map.of(
        1, "rgba(178,6,6,255)", 
        2, "rgba(74,168,211,255)", 
        3, "rgba(0,10,79,255)",  
        4, "rgba(13,117,2,255)", 
        5, "rgba(8,11,166,255)", 
        6, "rgba(205,169,77,255)", 
        7, "rgba(127,128,123,255)",
        8, "rgba(255,255,255,255)"  
));
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
        Especialidad especialidadSeleccionada = especialidadService.buscarEspecialidadPorId(idEspe);

        List<Alumno> alumnos = alumnoService.buscarCurso(especialidadSeleccionada, curso, seccion, "activo");

        // Ensure that alumnos is never null
        if (alumnos == null) {
            alumnos = new ArrayList<>(); // Create an empty list if no alumnos are found
        }

        model.addAttribute("especialidad", especialidadSeleccionada);
        model.addAttribute("alumnos", alumnos);

        // Add a flag to check if the list is empty
        if (alumnos.isEmpty()) {
            model.addAttribute("noAlumnos", true); // Set flag to true if no alumnos
        } else {
            model.addAttribute("alumnoCabecera", alumnos.get(0)); // Show the first student in the header
        }

        return "especialidades/verEspecialidad";
    }

    @GetMapping("/verFormularios")
    public String verFormularios() {
        return "verFormularios";
    }

    @GetMapping("/verTablas")
    public String verTablas() {
        return "verTablas";
    }

    @GetMapping("/verAsistenciasPorCurso/{idEspe}")
    public String verAsistenciasCurso() {

        return "verAsistenciaCurso";
    }
}
