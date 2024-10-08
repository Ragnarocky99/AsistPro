package com.example.controllers;

import com.example.model.Alumno;
import com.example.service.IAlumnoService;
import com.example.service.IDetalleAsistenciaService;
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
        List<Alumno> alumnos = alumnoService.listarAlumnosActivos();
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
        alumno.setEstado("activo");
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
        Alumno a = alumnoService.buscarAlumnoPorID(id);
        a.setEstado("inactivo");
        alumnoService.guardar(a);
        return "redirect:/alumnos/";

    }
    
    @Autowired
    private IDetalleAsistenciaService detalleAsistenciaService;

    @GetMapping("/verAsistencias/{idEspe}/alumnos")
    public String verAlumnosPorCursoSeccionFecha(
                                                @RequestParam("curso") String curso, 
                                                @RequestParam("seccion") String seccion, 
                                                @RequestParam("fecha") String fecha, 
                                                Model model) {


        return "verAlumnos";
    }
    
    @GetMapping("/desactivarCurso/{idAlumno}")
    public String desactivarCurso(@PathVariable("idAlumno") int idalumno) {
        Alumno a = alumnoService.buscarAlumnoPorID(idalumno);
        
        List<Alumno> curso = alumnoService.buscarAlumnosPorCursoYSeccionYEstado(a.getEspecialidad().getId_especialidad(), a.getCurso(), a.getSeccion(), "activo");
        for (Alumno alumno : curso) {
            alumno.setEstado("inactivo");
            alumnoService.guardar(alumno);
        }
        return "redirect:/" ; 
    }

}
