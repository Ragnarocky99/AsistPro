/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.service;

import com.example.model.Sala;
import java.util.List;

/**
 *
 * @author Anibal
 */
public interface ISalaService {
    List<Sala> listarSalas();
    void eliminarSala(int id);
    void guardarSala(Sala sala);
    Sala buscarSalaPorId(int id);
    Sala buscarPorLector(int id);
}
