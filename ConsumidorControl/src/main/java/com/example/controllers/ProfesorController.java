
package com.example.controllers;

import com.example.model.Profesor;
import com.example.service.IProfesorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "profesores")
public class ProfesorController {
    @Autowired 
    private IProfesorService profesorService;
    
    @GetMapping("/")
    private String verProfes(Model model){
        List<Profesor> profes = profesorService.listarProfesores();
        model.addAttribute("profesores", profes);
        return "verProfesores";
    }
    
    @GetMapping("/nuevoProfesor")
    public String nuevoProfesor(Model model){
        model.addAttribute("profesor", new Profesor());
        return "formularios/formularioProfesor";
    }
    
    @PostMapping("/guardarProfesor")
    public String guardarProfesor(@Valid Profesor profesor, Errors error) {
        if (error.hasErrors()) {
            return "formularios/formularioProfesor";
        }
        profesorService.guardar(profesor);
        return "redirect:/profesores/";
    }
    
    @GetMapping("/eliminarProfesor/{idprofesor}")
    public String eliminarProfesor(@PathVariable("idprofesor") int id) {
        profesorService.eliminar(id);
        return "redirect:/profesores/";
    }
    
    @GetMapping("/editarProfesor/{idprofesor}")
    public String editarProfesor(@PathVariable("idprofesor") int id, Model model) {
        Profesor profe = profesorService.buscarProfesorPorID(id);
        model.addAttribute("profesor", profe);
        return "formularios/formularioProfesor";
    }
    
    @GetMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model){
        List<Profesor> profesores = profesorService.buscarPorNombre(nombre);
        model.addAttribute("profesoresFiltrados", profesores);
        return "filtrados/profesoresFiltrados";
    }
    
}
