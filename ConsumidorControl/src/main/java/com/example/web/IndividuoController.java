package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.domain.Individuo;
import com.example.servicio.IndividuoServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndividuoController {

    @Autowired
    private IndividuoServicio individuoServicio;

    @GetMapping("/verIndividuos")
    public String comienzo(Model model) {
        Iterable<Individuo> individuos = individuoServicio.listaIndividuos();
        model.addAttribute("individuos", individuos);
        return "indice"; // Suponiendo que "indice" es el nombre de tu vista HTML
    }
    
    @GetMapping("/nuevoIndividuo")
    public String nuevoIndividuo(Individuo individuo) {
        return "formulario";
    }
    
    @PostMapping("/guardarIndividuo")
    public String guardarIndividuo(@Valid Individuo individuo, Errors error) {
        if (error.hasErrors()) {
            return "formulario";
        }
        individuoServicio.guardar(individuo);
        return "redirect:/verIndividuos";
    }
    
    @GetMapping("/editarIndividuo/{idindividuo}") 
    public String editarIndividuo(Individuo individuo, Model model){
        individuo = individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "formulario";
    }
    
    @GetMapping("/eliminarIndividuo")
    public String eliminarIndividuo(Individuo i) {
        individuoServicio.borrar(i);
        return "redirect:/";
    }
    
    @GetMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Individuo> individuos = individuoServicio.buscarPorNombre(nombre);
        model.addAttribute("individuosFiltrados", individuos);
        return "individuos"; // Suponiendo que "individuos" es el nombre de tu vista HTML para mostrar los resultados
    }

}
