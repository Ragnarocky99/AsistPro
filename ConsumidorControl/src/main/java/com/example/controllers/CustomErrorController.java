/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomErrorController implements ErrorController {

    // Manejador para errores 403 (acceso denegado)
    @GetMapping("/403")
    public String accessDenied() {
        return "errores/403"; // Retorna la página personalizada 403.html
    }

    // Manejador genérico de errores
    @RequestMapping("/error")
    public String handleError(Model model, WebRequest webRequest) {
        // Aquí puedes capturar detalles adicionales del error si es necesario
        model.addAttribute("message", "An unexpected error occurred.");
        return "errores/error"; // Retorna la página personalizada error.html
    }
}
