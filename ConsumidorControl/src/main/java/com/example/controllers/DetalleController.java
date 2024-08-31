package com.example.controllers;

import com.example.model.DetalleAsistencia;
import com.example.service.IDetalleAsistenciaService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
            
            return "verDetalles";
        }
        redirect.addFlashAttribute("advertencia", "No se registraron asistencias este dia");
        return "redirect:/";

    }
    
@PostMapping("/actualizarPresencia/{idAsistencia}/{idAlumno}")
public String actualizarPresencia(@PathVariable("idAsistencia") int idAsistencia,
                                  @PathVariable("idAlumno") int idAlumno,
                                  @RequestParam(value = "esta_presente", required = false) Boolean estaPresente,
                                  RedirectAttributes redirectAttribrutes) {
    DetalleAsistencia d = detalleService.buscarAsistenciaDeAlumno(idAlumno, idAsistencia);
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


}
