package com.example.controllers;

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
import com.example.service.IEspecialidadService;

@Controller
@RequestMapping(value = "excel")
public class ExcelController {
    @Autowired
    private IEspecialidadService espeService;
    @Autowired
    private ExcelService excelService;

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
            redirectAttributes.addFlashAttribute("message", "Alumnos cargados exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al cargar los alumnos: " + e.getMessage());
        }
        return "redirect:/";
    }

}
