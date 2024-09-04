/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.model.Sala;
import com.example.repository.EspecialidadRepository;
import com.example.repository.HorarioRepository;
import com.example.repository.LectorHuellaRepository;
import com.example.repository.SalaRepository;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImplement implements IHorarioService {

    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private EspecialidadRepository especialiadRepository;
    @Autowired
    private SalaRepository salaRepo;
    @Autowired
    private LectorHuellaRepository lectorRepo;

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
                .orElseThrow(() -> new RuntimeException("NO se encontro la especialidad"));
        return horarioRepository.findByEspecialidad(especialidad);
    }

    @Override
    public Horario buscarPorSalaYPorHora(int idSala, LocalTime hora) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
//
//    @Override
//    public Horario buscarHorariosMasCercanosPorEspeYSeccion(int idsala, LocalTime hora, Especialidad espe, int seccion) {
//        Sala sala = salaRepo.findById(idsala)
//                .orElseThrow(() -> new RuntimeException("NO se encontro la sala"));
//        System.out.println("sala: " + sala.getNombre());
//        return horarioRepository.findHariosDisponibles(idsala, hora, espe.getId_especialidad(), seccion);
//    }

    @Override
    public Horario buscarHorariosMasCercanosPorEspeYSeccion(int idsala, LocalTime hora, Especialidad especialidad, int seccion, String diaSemana) {
        return horarioRepository.findHorariosDisponibles(idsala, hora, especialidad.getId_especialidad(), seccion, diaSemana);
    }

}
