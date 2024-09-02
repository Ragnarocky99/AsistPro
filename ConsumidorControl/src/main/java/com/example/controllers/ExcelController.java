package com.example.controllers;

import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import com.example.model.Especialidad;
import com.example.service.ExcelService;
import com.example.service.IAsistenciaService;
import com.example.service.IDetalleAsistenciaService;
import com.example.service.IEspecialidadService;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

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
        List<DetalleAsistencia> detalles = detalleService.buscarDetallesPorAsistencia(idAsistencia);
        if (detalles == null) {
            System.out.println("no se encontro nada");
        }
        String especialidad = detalles.get(0).getAlumno().getEspecialidad().getNombre(); // Asumiendo que cada alumno tiene una especialidad
        String curso = detalles.get(0).getAlumno().getCurso();
        String seccion = String.valueOf(detalles.get(0).getAlumno().getSeccion());

        // Crear un nombre de archivo personalizado
        String fileName = "Asistencias_" + especialidad + "_" + curso + "_" + seccion + ".xlsx";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Asistencias");

        // Crear encabezado
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Está Presente");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Apellido");
        headerRow.createCell(3).setCellValue("Está en Clase");
        headerRow.createCell(4).setCellValue("Hora de Llegada");
        headerRow.createCell(5).setCellValue("Rasgos");

        // Llenar datos
        int rowNum = 1;
        for (DetalleAsistencia detalle : detalles) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(detalle.isEsta_presente() ? "Sí" : "No");
            row.createCell(1).setCellValue(detalle.getAlumno().getNombre());
            row.createCell(2).setCellValue(detalle.getAlumno().getApellido());
            row.createCell(3).setCellValue(detalle.isEsta_presente() ? "Sí" : "No");
            row.createCell(4).setCellValue(detalle.getHora_presencia() != null ? detalle.getHora_presencia().toString() : "");

            // Si "rasgos" es un String en formato "n1,n2,n3"
            String rasgos = detalle.getRasgos();
            row.createCell(5).setCellValue(rasgos);


        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(baos.toByteArray());
    }
}
