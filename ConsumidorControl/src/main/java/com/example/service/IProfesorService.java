/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.service;

import com.example.model.Profesor;
import java.util.List;

/**
 *
 * @author Anibal
 */
public interface IProfesorService {
    
    List<Profesor> listarProfesores();
    void guardar(Profesor profesor);
    Profesor buscarProfesorPorID(int id);
    void eliminar(int id);
    
    
}
