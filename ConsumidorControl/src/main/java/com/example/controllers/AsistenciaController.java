package com.example.controllers;

import com.example.model.Alumno;
import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.model.Sala;
import com.example.service.DetalleAsistenciaServiceImplement;
import com.example.service.IAlumnoService;
import com.example.service.IAsistenciaService;
import com.example.service.IDetalleAsistenciaService;
import com.example.service.IEspecialidadService;
import com.example.service.IHorarioService;
import com.example.service.ISalaService;
import jakarta.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public String verAsistencias(Model model) {
        List<Asistencia> asistencias = asistenciaService.listarAsistencias();
        model.addAttribute("asistencias", asistencias);
        return "verAsistencias";
    }
    
    @GetMapping("/reporte")
     public String verAsis(Model model){
        List<Asistencia> asistencias = asistenciaService.listarAsistencias();
        model.addAttribute("asistencias", asistencias);
        return "verAsistenciaRasgos";
    }
    
    @PostMapping("/nuevaAsistencia")
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
            return "formularios/formularioAsistencia";
        }
        asistenciaService.guardarAsistencia(asistencia);
        return "redirect:/asistencias/";
    }

    @GetMapping("/guardarAsistenciaAutomaticamente/{idLector}/{idAlumno}")
    public String asistenciaAutomatica(@PathVariable("idLector") int idLector, @PathVariable("idAlumno") int idAlumno) {
        LocalTime horaActual = LocalTime.now();
        LocalDate fechaHoy = LocalDate.now();
        DayOfWeek diaSemana = fechaHoy.getDayOfWeek();
        if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
            return "redirect:/dia-no-permitido"; // Redireccionar o manejar la situación si es sábado o domingo
        }
        if ((horaActual.isAfter(LocalTime.of(9, 20)) && horaActual.isBefore(LocalTime.of(9, 40)))
                || (horaActual.isAfter(LocalTime.of(12, 0)) && horaActual.isBefore(LocalTime.of(13, 0)))) {
            return "redirect:/horario-no-permitido"; // Redireccionar o manejar la situación
        }

        // Verificar si la hora actual está entre 9:20 y 9:40 o entre 12:00 y 13:00
        Sala salaActual = salaService.buscarPorLector(idLector);
        if (salaActual == null) {
            System.out.println("sala no encontradad");
            return "redirect:/error"; // Redireccionar a una página de error si la sala no se encuentra
        }

        Alumno a = alumnoService.buscarAlumnoPorID(idAlumno);
        if (a == null) {
            System.out.println("alumno no encontrado");
            return "redirect:/error"; // Redireccionar si el alumno no se encuentra
        }
        System.out.println("/\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("alumno" + a.getNombre());
        System.out.println("alumno" + a.getEspecialidad().getNombre());
        System.out.println("alumno" + a.getCurso());
        System.out.println("alumno" + a.getSeccion());

        Horario horario_actual = horarioService.buscarHorariosMasCercanosPorEspeYSeccion(salaActual.getId_sala(), horaActual, a.getEspecialidad(), a.getSeccion());
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\nid horario" + horario_actual.getId_horario() + horario_actual.getEspecialidad().getNombre() + "\n\n\n\n\n\n\n\n");
        if (horario_actual == null) {
            System.out.println("horario no encontrado");

            return "redirect:/"; // Redireccionar si no hay horario
        }

        Asistencia asistenciaExistence = asistenciaService.buscarAsistenciaPorFechaYHorario(fechaHoy, horario_actual);

        if (asistenciaExistence == null) {
            Asistencia asistencia = new Asistencia();
            asistencia.setFecha(fechaHoy);
            asistencia.setHorario(horario_actual);
            asistenciaService.guardarAsistencia(asistencia);
            asistenciaExistence = asistencia; // Actualizar la referencia
            System.out.println("/\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("especialidad" + a.getEspecialidad().getNombre());
            System.out.println("curso" + a.getCurso());
            System.out.println("seccion" + a.getSeccion());
            System.out.println("/\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            List<Alumno> curso = alumnoService.buscarCurso(a.getEspecialidad(), a.getCurso(), a.getSeccion(), "activo");
            if (curso == null) {
                System.out.println("hola dos");
                return ":redirect:/";
            }
            for (Alumno alumno : curso) {
                System.out.println("alumno: " + alumno.getCurso());
                System.out.println("alumno: " + alumno.getEspecialidad().getNombre());
                DetalleAsistencia detalle = new DetalleAsistencia();
                detalle.setAsistencia(asistenciaExistence);
                detalle.setAlumno(alumno);
                detalle.setHora_presencia(null);

                boolean esTarde = horario_actual.getHora_inicio().plusMinutes(20).isBefore(horaActual);
                detalle.setEsta_presente(false);

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
            System.out.println("error actualizando");
            return "redirect:/error";
        }

        DetalleAsistencia detalle = new DetalleAsistencia();
        detalle.setRasgos("");
        detalle.setAsistencia(asistenciaExistence);
        detalle.setAlumno(alumno);
        detalle.setHora_presencia(horaActual);
        return "redirect:/detalle-asistencias/verDetalles/" + asistenciaExistence.getId_asistencia();
    }


    @Autowired
    private IDetalleAsistenciaService detalleAsistenciaService;

        detalleService.guardarDetalle(detalle);

        return "redirect:/detalle-asistencias/verDetalles/" + asistenciaExistence.getId_asistencia();
    }

    
    @GetMapping("/verAsistenciasPorCurso/{idesp}/{idal}")
    public String verAsistenciasPorCurso(@PathVariable("idesp") int idEspe,
                                        @PathVariable("idal") int idAlumno,
                                        Model model) {
        Alumno a = alumnoService.buscarAlumnoPorID(idAlumno);
        List<Asistencia> asistenciasDelCurso = asistenciaService.buscarAsistenciasDelCurso(LocalDate.now(), idEspe, a.getCurso(), a.getSeccion());
        if (asistenciasDelCurso.isEmpty() || asistenciasDelCurso == null) {
            return "redirect:/";
        }
        model.addAttribute("asistencias", asistenciasDelCurso);
        return "verAsistenciaCurso";
    }

}
