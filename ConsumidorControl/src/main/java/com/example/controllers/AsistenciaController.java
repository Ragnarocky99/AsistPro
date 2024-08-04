package com.example.controllers;

import com.example.model.Asistencia;
import com.example.model.Horario;
import com.example.service.IAsistenciaService;
import com.example.service.IEspecialidadService;
import com.example.service.IHorarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    
}
