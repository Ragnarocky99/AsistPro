/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.service;

import com.example.model.Especialidad;
import com.example.model.Horario;
import java.time.LocalTime;
import java.util.List;

public interface IHorarioService {
    List<Horario> listarHorarios();
    void guardarHorario(Horario horario);
    void eliminarHorario(int id);
    Horario buscarHorarioPorId(int id);
    List<Horario> buscarHorarioPorEspeciialidad(int idespecialidad);
    Horario buscarPorSalaYPorHora(int sala, LocalTime hora);
    Horario buscarHorariosMasCercanosPorEspeYSeccion(int idsala, LocalTime hora, Especialidad especialidad, int seccion);
}
