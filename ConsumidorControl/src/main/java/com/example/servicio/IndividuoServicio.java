/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicio;

import com.example.domain.Individuo;
import java.util.List;

public interface IndividuoServicio {
    List<Individuo> listaIndividuos();
    void guardar(Individuo individuo);
    void borrar(Individuo individuo);
    Individuo localizarIndividuo(Individuo individuo);
    List<Individuo> buscarPorNombre(String nombre);
    
}
