/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Especialidad;
import com.example.repository.EspecialidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anibal
 */
@Service
public class EspecialidadServiceImplement implements IEspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository; 
            
    @Override
    public List<Especialidad> listarEspecialidades() {
        return (List<Especialidad>) especialidadRepository.findAll();
    }

    @Override
    public void guardarEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad buscarEspecialidadPorId(int id) {
        return especialidadRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEspecialidad(int id) {
        especialidadRepository.deleteById(id);
    }
    
}
