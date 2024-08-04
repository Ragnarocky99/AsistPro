/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.repository.EspecialidadRepository;
import com.example.repository.HorarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImplement implements IHorarioService{
    
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private EspecialidadRepository especialiadRepository;

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public void guardarHorario(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public void eliminarHorario(int id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public Horario buscarHorarioPorId(int id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Horario> buscarHorarioPorEspeciialidad(int idespecialidad) {
        Especialidad especialidad = especialiadRepository.findById(idespecialidad)
                .orElseThrow(() -> new RuntimeException("NO se encontro la especialidad") );
        return horarioRepository.findByEspecialidad(especialidad);
    }

    
}
