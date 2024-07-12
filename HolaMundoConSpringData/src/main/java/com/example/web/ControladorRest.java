package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.dao.IndividuoDao;
import com.example.domain.Individuo;

@Controller
public class ControladorRest {

    @Autowired
    private IndividuoDao individuoDao;

    @GetMapping("/")
    public String comienzo(Model model) {
        Iterable<Individuo> individuos = individuoDao.findAll();
        model.addAttribute("individuos", individuos);
        return "indice"; // Suponiendo que "indice" es el nombre de tu vista HTML
    }
}
