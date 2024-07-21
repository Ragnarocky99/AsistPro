
package com.example.controllers;

import com.example.model.Profesor;
import com.example.service.IProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "profesores")
public class ProfesorController {
    @Autowired 
    private IProfesorService profesorService;
    
    @GetMapping("/verProfesores")
    private String verProfes(Model model){
        List<Profesor> profes = profesorService.listarProfesores();
        model.addAttribute("profesores", profes);
        return "verProfes";
    }
}
