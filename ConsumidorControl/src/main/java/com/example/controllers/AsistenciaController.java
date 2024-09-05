package com.example.controllers;

import com.example.model.Alumno;
import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import com.example.model.Horario;
import com.example.model.Sala;
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
        LocalDate fechaHoy = LocalDate.now();
        DayOfWeek diaSemana = fechaHoy.getDayOfWeek();
        String diaSemanaStr = obtenerDiaEnEspañol(diaSemana);
        // Convertir a "Lunes", "Martes", etc.

        if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
            System.out.println("dia");
            return "redirect:/dia-no-permitido";
        }

        // El resto del código permanece igual
        Sala salaActual = salaService.buscarPorLector(idLector);
        if (salaActual == null) {
            System.out.println("sala");
            return "redirect:/error";
        }

        Alumno a = alumnoService.buscarAlumnoPorID(idAlumno);
        if (a == null) {
            System.out.println("alumno");
            return "redirect:/error";
        }

        // Modificar la llamada a la búsqueda de horario para incluir el día de la semana
        Horario horario_actual = horarioService.buscarHorarioActual(salaActual.getId_sala(), horaActual, a.getEspecialidad().getId_especialidad(), a.getCurso(), a.getSeccion(), diaSemanaStr);

        if (horario_actual == null) {
            System.out.println("\n\n\n\n\n\nhorario\n\n\n\n");
            return "redirect:/";
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

        return "redirect:/detalle-asistencias/verDetalles/" + asistenciaExistence.getId_asistencia();
    }

    @Autowired
    private IDetalleAsistenciaService detalleAsistenciaService;

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

    private String obtenerDiaEnEspañol(DayOfWeek diaSemana) {
        switch (diaSemana) {
            case MONDAY:
                return "LUNES";
            case TUESDAY:
                return "MARTES";
            case WEDNESDAY:
                return "MIÉRCOLES";
            case THURSDAY:
                return "JUEVES";
            case FRIDAY:
                return "VIERNES";
            case SATURDAY:
                return "SÁBADO";
            case SUNDAY:
                return "DOMINGO";
            default:
                throw new IllegalArgumentException("Día inválido: " + diaSemana);
        }
    }

}
