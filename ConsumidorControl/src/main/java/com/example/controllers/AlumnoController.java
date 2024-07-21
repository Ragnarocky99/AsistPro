package com.example.controllers;

import com.example.model.Alumno;
import com.example.service.IAlumnoService;
import com.example.service.IEspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "alumnos")
public class AlumnoController {
    
    @Autowired
    private IAlumnoService alumnoService;
    @Autowired
    private IEspecialidadService especialidadService;
    
    @GetMapping("/nuevoAlumno")
    public String nuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("especialidades", especialidadService.listarEspecialidades());
        return "formularios/formularioAlumno";
    }
    
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(@Valid Alumno alumno, Errors error) {
        if (error.hasErrors()) {
            return "formularios/formularioAlumno";
        }
        alumnoService.guardar(alumno);
        return "redirect:/";
    }
    
}
