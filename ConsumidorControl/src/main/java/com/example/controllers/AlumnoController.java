package com.example.controllers;

import com.example.model.Alumno;
import com.example.service.IAlumnoService;
import com.example.service.IEspecialidadService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;
    @Autowired
    private IEspecialidadService especialidadService;

    @GetMapping("/")
    public String verAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "verAlumnos";
    }

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
        return "redirect:/alumnos/";
    }

    @GetMapping("/buscarPorNombre")
    public String buscarAlumnoPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Alumno> alumnosFiltrados = alumnoService.buscarPorNombre(nombre);
        model.addAttribute("alumnosFiltrados", alumnosFiltrados);
        return "filtrados/alumnosFiltrados";
    }

    @GetMapping("/editarAlumno/{idalumno}")
    public String editarAlumno(@PathVariable("idalumno") int id, Model model) {
        Alumno alumno = alumnoService.buscarAlumnoPorID(id);
        model.addAttribute("alumno", alumno);
        model.addAttribute("especialidades", especialidadService.listarEspecialidades());
        return "formularios/formularioAlumno";
    }

    @GetMapping("/eliminarAlumno/{idAlumno}")
    public String eliminarAlumno(@PathVariable("idAlumno") int id) {
        alumnoService.eliminar(id);
        return "redirect:/alumnos/";

    }

}
