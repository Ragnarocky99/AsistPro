package com.example.controllers;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.service.IDetalleAsistenciaService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
            model.addAttribute("idAsistencia", idAsistencia);
            return "verDetalles";
        }
        redirect.addFlashAttribute("advertencia", "No se registraron asistencias este dia");
        return "redirect:/";

    }

    @PostMapping("/asignarRasgos")
    public String asignarRasgos(@RequestParam("idAsistencia") int idAsistencia, 
                            @RequestParam("idAlumno") int idAlumno, 
                            @RequestParam(value = "rasgos", required = false) List<String> rasgos) {
    
        // Crear el ID para buscar el detalle
        DetalleAsistenciaId id = new DetalleAsistenciaId(idAsistencia, idAlumno);
    
        // Buscar el detalle de asistencia para el alumno en la asistencia dada
        Optional<DetalleAsistencia> detalleop = detalleService.localizarDetalleporIdd(id);
        if (!detalleop.isPresent()) {
            return "redirect:/error"; 
        }
        DetalleAsistencia detalle = detalleop.get();
    
        // Obtener los rasgos actuales del detalle (si existen)
        Set<String> rasgosExistentes = new HashSet<>();
            if (detalle.getRasgos() != null && !detalle.getRasgos().isEmpty()) {
            rasgosExistentes.addAll(Arrays.asList(detalle.getRasgos().split(", ")));
        }
    
        // Si no hay rasgos proporcionados, vaciar los rasgos existentes
        if (rasgos == null || rasgos.isEmpty()) {
            rasgosExistentes.clear();
        } else {
            // Convertir la lista de rasgos proporcionados en un set para eliminar duplicados
            Set<String> nuevosRasgos = new HashSet<>(rasgos);
        
            // Eliminar rasgos que ya no están en la lista proporcionada
            rasgosExistentes.retainAll(nuevosRasgos);
        
            // Agregar los nuevos rasgos
            rasgosExistentes.addAll(nuevosRasgos);
        }
        // Actualizar los rasgos en el detalle
        detalle.setRasgos(String.join(", ", rasgosExistentes));
        // Guardar los cambios en el detalle
        detalleService.guardarDetalle(detalle);
        return "redirect:/detalle-asistencias/verDetalles/" + idAsistencia;
    }
}
