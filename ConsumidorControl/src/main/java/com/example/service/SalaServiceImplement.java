/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Sala;
import com.example.repository.SalaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceImplement implements ISalaService{
    @Autowired
    private SalaRepository salaRepository;
    
    @Override
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    @Override
    public void eliminarSala(int id) {
        salaRepository.deleteById(id);
    }

    @Override
    public void guardarSala(Sala sala) {
        salaRepository.save(sala);
    }

    @Override
    public Sala buscarSalaPorId(int id) {
        return salaRepository.findById(id).orElse(null);
    }
    
}
