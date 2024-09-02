package com.example.controllers;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.service.IDetalleAsistenciaService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "detalle-asistencias")
public class DetalleController {

    @Autowired
    private IDetalleAsistenciaService detalleService;

    @GetMapping("/verDetalles/{idAsistencia}")
    public String verDetallesPorAsistencia(@PathVariable("idAsistencia") int idAsistencia, Model model,
            RedirectAttributes redirect) {
        List<DetalleAsistencia> detalles = detalleService.listarDetallesPorAsistencia(idAsistencia);

        if (detalles != null && !detalles.isEmpty()) {
            model.addAttribute("detalleCabecera", detalles.get(0));
            model.addAttribute("detalles", detalles);

            // Cargar la lista de rasgos
            List<Rasgo> rasgos = Arrays.asList(
                    new Rasgo("Llegada Tardía", "N1"),
                    new Rasgo("Salida Temprana", "N2"),
                    new Rasgo("Inasistencia Justificada", "N3"),
                    new Rasgo("Inasistencia Injustificada", "N4"),
                    new Rasgo("Participación Activa", "N5"),
                    new Rasgo("Comportamiento Ejemplar", "N6"),
                    new Rasgo("Retraso en Entrega de Tareas", "N7"),
                    new Rasgo("Trabajo en Grupo Deficiente", "N8")
            );
            model.addAttribute("rasgos", rasgos);

            // Crear el mapa de rasgos por alumno
            Map<Integer, String> rasgosPorAlumno = new HashMap<>();
            for (DetalleAsistencia d : detalles) {
                String rasgosStr = d.getRasgos();
                if (rasgosStr != null) {
                    // Unir los rasgos en una sola cadena separada por comas
                    String joinedRasgos = String.join(", ", Arrays.asList(rasgosStr.split(", ")));
                    rasgosPorAlumno.put(d.getAlumno().getId_alumno(), joinedRasgos);
                } else {
                    rasgosPorAlumno.put(d.getAlumno().getId_alumno(), "");
                }
            }
            model.addAttribute("rasgosPorAlumno", rasgosPorAlumno);

            return "verDetalles";
        }
        redirect.addFlashAttribute("advertencia", "No se registraron asistencias este día");
        return "redirect:/";
    }

    @PostMapping("/actualizarPresencia/{idAsistencia}/{idAlumno}")
    public String actualizarPresencia(@PathVariable("idAsistencia") int idAsistencia,
            @PathVariable("idAlumno") int idAlumno,
            @RequestParam(value = "esta_presente", required = false) Boolean estaPresente,
            RedirectAttributes redirectAttribrutes) {
        DetalleAsistencia d = detalleService.buscarAsistenciaDeAlumno(idAlumno, idAsistencia);
        if (d.getHora_presencia() == null) {
            return "redirect:/detalle-asistencias/verDetalles/" + idAsistencia;
        }
        System.out.println("idasis: " + idAsistencia);
        System.out.println("idAlumno: " + idAlumno);
        if (estaPresente == null) {
            estaPresente = false;
        }

        if (d != null) {
            d.setEsta_presente(estaPresente);
            detalleService.guardarDetalle(d);
        } else {
            redirectAttribrutes.addFlashAttribute("error", "No se encontró el detalle de asistencia para el alumno.");
        }
        return "redirect:/detalle-asistencias/verDetalles/" + idAsistencia;
    }

    @PostMapping("/actualizarRasgos/{idasis}/{idalum}")
    public String asignarRasgos(@PathVariable("idasis") int idAsistencia,
            @PathVariable("idalum") int idAlumno,
            @RequestParam(value = "rasgos", required = false) List<String> rasgos) {

        // Crear el ID para buscar el detalle
        DetalleAsistenciaId id = new DetalleAsistenciaId(idAsistencia, idAlumno);

        // Buscar el detalle de asistencia para el alumno en la asistencia dada
        Optional<DetalleAsistencia> detalleOp = detalleService.localizarDetalleporIdd(id);
        if (detalleOp.isEmpty()) {
            return "redirect:/error";
        }
        DetalleAsistencia detalle = detalleOp.get();

        // Verificar la hora de presencia
        if (detalle.getHora_presencia() == null) {
            return "redirect:/detalle-asistencias/verDetalles/" + idAsistencia;
        }

        // Manejar rasgos
        Set<String> rasgosExistentes = new HashSet<>();
        if (detalle.getRasgos() != null) {
            rasgosExistentes.addAll(Arrays.asList(detalle.getRasgos().split(", ")));
        }

        if (rasgos == null || rasgos.isEmpty()) {
            // Si no hay rasgos proporcionados, vaciar los rasgos existentes
            rasgosExistentes.clear();
        } else {
            // Convertir la lista de rasgos proporcionados en un set para eliminar duplicados
            Set<String> nuevosRasgos = new HashSet<>(rasgos);
            // Actualizar los rasgos existentes con los nuevos rasgos
            rasgosExistentes = nuevosRasgos;
        }

        // Actualizar los rasgos en el detalle
        detalle.setRasgos(String.join(",", rasgosExistentes));
        // Guardar los cambios en el detalle
        detalleService.guardarDetalle(detalle);

        return "redirect:/detalle-asistencias/verDetalles/" + idAsistencia;
    }

    // Clase interna para representar un Rasgo
    public static class Rasgo {

        private String nombre;
        private String valor;

        public Rasgo(String nombre, String valor) {
            this.nombre = nombre;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
    }

}
