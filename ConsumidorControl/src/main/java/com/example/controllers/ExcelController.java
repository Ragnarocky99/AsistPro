package com.example.controllers;

import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Especialidad;
import com.example.service.ExcelService;
import com.example.service.IAsistenciaService;
import com.example.service.IDetalleAsistenciaService;
import com.example.service.IEspecialidadService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value = "excel")
public class ExcelController {

    @Autowired
    private IDetalleAsistenciaService detalleService;
    @Autowired
    private IEspecialidadService espeService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private IAsistenciaService asistenciaService;

    @GetMapping("/subir-excel")
    public String mostrarFormularioSubida(Model model) {
        List<Especialidad> espes = espeService.listarEspecialidades();
        model.addAttribute("especialidades", espes);
        return "subirExcel";
    }

    @PostMapping("/cargarAlumnos")
    public String uploadAlumnos(@RequestParam("especialidad") int idEspecialidad,
            @RequestParam("curso") String curso,
            @RequestParam("seccion") int seccion,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        try {
            excelService.cargarAlumnosDesdeExcel(file, idEspecialidad, curso, seccion);
            redirectAttributes.addFlashAttribute("advertencia", "Alumnos cargados exitosamente");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("advertencia", "Error al cargar los alumnos: " + e.getMessage());
            System.out.println("alumnos no cargados");
        }
        return "redirect:/";
    }

    @GetMapping("/exportarAsistenciasExcel/{idasis}")
    public ResponseEntity<byte[]> exportarAsistenciasExcel(@PathVariable("idasis") int idAsistencia) throws IOException {
        Asistencia a = asistenciaService.buscarAsistenciaPorId(idAsistencia);
        // Suponiendo que 'detalles' es la lista de datos que quieres exportar
        List<DetalleAsistencia> detalles = detalleService.buscarDetallesPorAsistencia(idAsistencia);// Obtener los detalles desde la base de datos o donde sea necesario

        // Crear un nuevo Workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Asistencias "
                + a.getHorario().getEspecialidad().getNombre()
                + " " + detalles.getFirst().getAlumno().getCurso() + " curso - "
                + a.getHorario().getSeccion() + " seccion - "
                + a.getHorario().getMateria().getNombre());

        // Crear encabezado
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Esta presente");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Apellido");
        headerRow.createCell(3).setCellValue("CDI");
        headerRow.createCell(4).setCellValue("Curso");
        headerRow.createCell(5).setCellValue("Sección");
        headerRow.createCell(6).setCellValue("Especialidad");
        headerRow.createCell(7).setCellValue("Hora de llegada");

        // Llenar datos
        int rowNum = 1;
        for (DetalleAsistencia detalle : detalles) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(detalle.isEsta_presente() ? "Sí" : "No");
            row.createCell(1).setCellValue(detalle.getAlumno().getNombre());
            row.createCell(2).setCellValue(detalle.getAlumno().getApellido());
            row.createCell(3).setCellValue(detalle.getAlumno().getCdi());
            row.createCell(4).setCellValue(detalle.getAlumno().getCurso());
            row.createCell(5).setCellValue(detalle.getAlumno().getSeccion());
            row.createCell(6).setCellValue(detalle.getAlumno().getEspecialidad().getNombre());
            row.createCell(7).setCellValue(detalle.getHora_presencia() != null ? detalle.getHora_presencia().toString() : "");
        }

        // Escribir el contenido a un ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();

        // Preparar la respuesta
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=asistencias.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(baos.toByteArray());
    }

}
