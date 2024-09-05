package com.example.controllers;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.service.IDetalleAsistenciaService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/export/{idasis}")
    public void exportDetallesPDF(@PathVariable int idasis, HttpServletResponse response) throws IOException {
        // Establecer el tipo de contenido y los encabezados de respuesta
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Asistencias" + idasis + ".pdf");

        // Obtener los detalles de asistencia
        List<DetalleAsistencia> detalles = detalleService.listarDetallesPorAsistencia(idasis);
        if (detalles != null && !detalles.isEmpty()) {
            DetalleAsistencia da = detalles.get(0);

            // Crear el documento PDF
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título del documento
            document.add(new Paragraph("Reporte de Asistencias de " + da.getAsistencia().getHorario().getMateria().getNombre()));
            document.add(new Paragraph("Fecha: " + da.getAsistencia().getFecha()));
            document.add(new Paragraph("Especialidad:" + da.getAsistencia().getHorario().getEspecialidad().getNombre()));
            document.add(new Paragraph("Curso: " + da.getAsistencia().getHorario().getCurso()));
            document.add(new Paragraph("Seccion: " + da.getAsistencia().getHorario().getSeccion()));
            document.add(new Paragraph("Hora de inicio: " + da.getAsistencia().getHorario().getHora_inicio()));
            document.add(new Paragraph("Hora de inicio: " + da.getAsistencia().getHorario().getHora_fin()));

            // Crear una tabla con las columnas correspondientes
            float[] columnWidths = {50, 75, 75, 75}; // Ajustar las proporciones según tus necesidades
            Table table = new Table(columnWidths);

            // Agregar los encabezados de la tabla
            table.addCell("Nombre Alumno");
            table.addCell("Presente");
            table.addCell("Hora llegada");
            table.addCell("Rasgos");

            // Mapa para los rasgos por alumno
            Map<Integer, String> rasgosPorAlumno = new HashMap<>();

            // Agregar los datos de los detalles de asistencia
            for (DetalleAsistencia d : detalles) {
                // Obtener los rasgos del alumno
                String rasgosStr = d.getRasgos();
                String joinedRasgos = (rasgosStr != null) ? String.join(", ", rasgosStr.split(", ")) : "";
                rasgosPorAlumno.put(d.getAlumno().getId_alumno(), joinedRasgos);

                // Agregar las celdas de los datos a la tabla
                table.addCell(d.getAlumno().getNombre() + " " + d.getAlumno().getApellido());  // Supongo que tienes un método para obtener el nombre completo
                table.addCell(d.isEsta_presente() ? "SI" : "NO");
                table.addCell(d.getHora_presencia() != null ? d.getHora_presencia().toString() : "-");
                table.addCell(joinedRasgos);
            }

            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
        }
    }

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
                    new Rasgo("Sale del aula sin autorización", "N2"),
                    new Rasgo("No realiza la tarea asignada en clase", "N3"),
                    new Rasgo("No dispone de los materiales necesarios", "N4"),
                    new Rasgo("No presenta las tareas asignadas para la casa", "N5"),
                    new Rasgo("Utiliza vocabulario indebido en clase", "N6"),
                    new Rasgo("Charla mucho en clase", "N7"),
                    new Rasgo("No utiliza el uniforme establecido", "N8"),
                    new Rasgo("Ausente en clase, presente en la Institución", "N9")
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
