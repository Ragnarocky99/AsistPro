package com.example.controllers;

import com.example.model.Alumno;
import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.model.Sala;
import com.example.service.IAlumnoService;
import com.example.service.IAsistenciaService;
import com.example.service.IDetalleAsistenciaService;
import com.example.service.IEspecialidadService;
import com.example.service.IHorarioService;
import com.example.service.ISalaService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "asistencias")
public class AsistenciaController {
    @Autowired
    private IAsistenciaService asistenciaService;
    @Autowired 
    private IHorarioService horarioService;
    @Autowired
    private IEspecialidadService especialidadService;
    @Autowired
    private ISalaService salaService;
    @Autowired
    private IAlumnoService alumnoService;
    @Autowired
    private IDetalleAsistenciaService detalleService;
    
    
    @GetMapping("/")
    public String verAsistencias(Model model){
        List<Asistencia> asistencias = asistenciaService.listarAsistencias();
        model.addAttribute("asistencias", asistencias);
        return "verAsistencias";
    }
    
    
    @GetMapping("/nuevaAsistencia")
    public String nuevaAsistencia(Model model) {
        Asistencia asistencia = new Asistencia();
        List<Horario> horarios = horarioService.listarHorarios();
        model.addAttribute("asistencia", asistencia);
        model.addAttribute("horarios", horarios);
        return "formularios/formularioAsistencia";
    }
    
    @PostMapping("/guardarAsistencia")
    public String saveAsistencia(@Valid @ModelAttribute("asistencia") Asistencia asistencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Horario> horarios = horarioService.listarHorarios();
            model.addAttribute("horarios", horarios);
            return "formulario/formularioAsistencia";
        }
        asistenciaService.guardarAsistencia(asistencia);
        return "redirect:/asistencias/";
    }

    @GetMapping("/guardarAsistenciaAutomaticamente/{idLector}/{idAlumno}")
    public String asistenciaAutomatica(@PathVariable("idLector") int idLector, @PathVariable("idAlumno") int idAlumno) {
        LocalTime horaActual = LocalTime.now();

        // Verificar si la hora actual está entre 9:20 y 9:40 o entre 12:00 y 13:00
        if ((horaActual.isAfter(LocalTime.of(9, 20)) && horaActual.isBefore(LocalTime.of(9, 40))) ||
            (horaActual.isAfter(LocalTime.of(12, 0)) && horaActual.isBefore(LocalTime.of(13, 0)))) {
            return "redirect:/"; // Redireccionar o manejar la situación
        }

        Sala salaActual = salaService.buscarPorLector(idLector);
        if (salaActual == null) {
            return "redirect:/error"; // Redireccionar a una página de error si la sala no se encuentra
        }

        Alumno a = alumnoService.buscarAlumnoPorID(idAlumno);
        if (a == null) {
            return "redirect:/error"; // Redireccionar si el alumno no se encuentra
        }

        Horario horario_actual = horarioService.buscarHorariosMasCercanos(salaActual.getId_sala(), horaActual);
        if (horario_actual == null) {
            return "redirect:/"; // Redireccionar si no hay horario
        }
        
        LocalDate fechaHoy = LocalDate.now();
        Asistencia asistenciaExistence = asistenciaService.buscarAsistenciaPorFechaYHorario(fechaHoy, horario_actual);

        if (asistenciaExistence == null) {
            Asistencia asistencia = new Asistencia();
            asistencia.setFecha(fechaHoy);
            asistencia.setHorario(horario_actual);
            asistenciaService.guardarAsistencia(asistencia);
            asistenciaExistence = asistencia; // Actualizar la referencia

            List<Alumno> curso = alumnoService.buscarAlumnosPorCursoSeccionEspe(a.getEspecialidad().getId_especialidad(), a.getCurso(), a.getSeccion());
            for (Alumno alumno : curso) {
                DetalleAsistencia detalle = new DetalleAsistencia();
                detalle.setAsistencia(asistenciaExistence);
                detalle.setAlumno(alumno);
                detalle.setHora_presencia(null);

                boolean esTarde = horario_actual.getHora_inicio().plusMinutes(20).isBefore(horaActual);
                detalle.setEsta_presente(!esTarde);

                detalleService.guardarDetalle(detalle);
            }
        }

        int idasistencia = asistenciaExistence.getId_asistencia();
        DetalleAsistencia d = detalleService.buscarAsistenciaDeAlumno(idAlumno, idasistencia);
        if (d != null) {
            d.setEsta_presente(true);
            d.setHora_presencia(horaActual);
            detalleService.guardarDetalle(d);
        } else {
            return "redirect:/error";
        }

        return "redirect:/detalle-asistencias/verDetalles/" + asistenciaExistence.getId_asistencia();
    }

    
    @Autowired
    private IDetalleAsistenciaService detalleAsistenciaService;

    @GetMapping("/verAsistencias/{idEspe}/alumnos")
    public String verAlumnosPorCursoSeccionFecha(
                                                @PathVariable("idEspe") int idEspe,
                                                @RequestParam("curso") String curso, 
                                                @RequestParam("seccion") int seccion, 
                                                @RequestParam("fecha") LocalDate fecha, 
                                                Model model) {
        List<Alumno> alumnos = alumnoService.buscarAlumnosPorCursoYSeccionYEstado(idEspe, curso, seccion, "activo");
        Especialidad especialidadSeleccionada = especialidadService.buscarEspecialidadPorId(idEspe);
        model.addAttribute("especialidad", especialidadSeleccionada);
        model.addAttribute("alumnos", alumnos);

        return "verAlumnos";
    }

    
    
}
