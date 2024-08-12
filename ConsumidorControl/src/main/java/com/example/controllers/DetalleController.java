package com.example.controllers;

import com.example.model.DetalleAsistencia;
import com.example.service.IDetalleAsistenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "detalle-asistencias")
public class DetalleController {
    @Autowired
    private IDetalleAsistenciaService detalleService;
    
    @GetMapping("/verDetalles/{idAsistencia}")
    public String verDetallesPorAsistencia(@PathVariable("idAsistencia") int idAsistencia, Model model) {
        List<DetalleAsistencia> detalles = detalleService.listarDetallesPorAsistencia(idAsistencia);
        
        model.addAttribute("detalleCabecera", detalles.getFirst());
        model.addAttribute("detalles", detalles);
        return "verDetalles";
    }
    
    
    
}
