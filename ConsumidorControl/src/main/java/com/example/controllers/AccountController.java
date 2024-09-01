/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;

import com.example.model.AppUser;
import com.example.model.Profesor;
import com.example.model.RegisterDto;
import com.example.repository.ProfesorRepository;
import com.example.repository.AppUserRepository;
import jakarta.validation.Valid;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nahue
 */
@Controller
public class AccountController {

    @Autowired
    private AppUserRepository repo;
    
    @Autowired
    private ProfesorRepository prof;

    @GetMapping("/register")
    public String register(Model model) {

        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success",false);
        return "register";

    }

    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterDto registerDto,
            BindingResult result
    ) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDto", "confirmPassword",
                            "Password and Confirm Password do not match")
            );

        }

        AppUser appUser = repo.findByEmail(registerDto.getEmail());
        if (appUser != null) {

            result.addError(
                    new FieldError("registerDto", "email",
                            "Email address is already used")
            );

        }

        if (result.hasErrors()) {
            return "register";
        }
        
        // Determinar el rol en función de si el email existe en la otra tabla
        String role;
        var otherTableEntry = prof.findByCorreo(registerDto.getEmail());
        
        if (otherTableEntry != null) {
            role = "PROFESOR"; // Si el email existe en la otra tabla, asignar el rol de PROFESOR
        } else {
            role = "QUERY"; // Si el email no existe, asignar el rol de QUERY
        }

        if (result.hasErrors()) {
            return "register";
        }

        try {
            
            var bCryptEncoder = new BCryptPasswordEncoder();
            AppUser newUser = new AppUser();
            newUser.setFirstName(registerDto.getFirstName()); newUser.setLastName(registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setRole(role);
            newUser.setCreatedAt(new Date());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword())); 
            repo.save(newUser);
            
            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success",true);

        } 
        catch (Exception e) {

            result.addError(
                    new FieldError("registerDto", "firstName",
                            e.getMessage())
            );

        }

        return "register";
    }

}
