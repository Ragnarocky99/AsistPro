package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.model.Individuo;
import com.example.service.IndividuoServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "individuos")
public class IndividuoController {

    @Autowired
    private IndividuoServicio individuoServicio;

    @GetMapping("/")
    public String comienzo(Model model) {
        Iterable<Individuo> individuos = individuoServicio.listaIndividuos();
        model.addAttribute("individuos", individuos);
        return "individuos"; // Suponiendo que "indice" es el nombre de tu vista HTML
    }
    
    @GetMapping("/nuevoIndividuo")
    public String nuevoIndividuo(Individuo individuo) {
        return "formularios/formularioIndividuo";
    }
    
    @PostMapping("/guardarIndividuo")
    public String guardarIndividuo(@Valid Individuo individuo, Errors error) {
        if (error.hasErrors()) {
            return "formularios/formularioIndividuo";
        }
        individuoServicio.guardar(individuo);
        return "redirect:/individuos/";
    }
    
    @GetMapping("/editarIndividuo/{idindividuo}") 
    public String editarIndividuo(Individuo individuo, Model model){
        individuo = individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "formularios/formularioIndividuo";
    }
    
    @GetMapping("/eliminarIndividuo/{idindividuo}")
    public String eliminarIndividuo(@PathVariable("idindividuo") Long id) {
        Individuo i = individuoServicio.buscarIndividuoPorId(id);
        individuoServicio.borrar(i);
        return "redirect:/individuos/";
    }
    
    @GetMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Individuo> individuos = individuoServicio.buscarPorNombre(nombre);
        model.addAttribute("individuosFiltrados", individuos);
        return "individuosFiltrados"; // Suponiendo que "individuos" es el nombre de tu vista HTML para mostrar los resultados
    }

}
