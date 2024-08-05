/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.service;

import com.example.model.Especialidad;
import java.util.List;

/**
 *
 * @author Anibal
 */
public interface IEspecialidadService {
    List<Especialidad> listarEspecialidades();
    void guardarEspecialidad(Especialidad especialidad);
    Especialidad buscarEspecialidadPorId(int id);
    void eliminarEspecialidad(int id);
}
