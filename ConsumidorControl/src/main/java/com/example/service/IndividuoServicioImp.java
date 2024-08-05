/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.repository.IndividuoRepository;

/**
 *
 * @author Anibal
 */
@Service
public class IndividuoServicioImp implements IndividuoServicio{
    
    @Autowired
    private IndividuoRepository individuoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) individuoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Individuo individuo) {
        individuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void borrar(Individuo individuo) {
        individuoDao.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Individuo individuo) {
        return individuoDao.findById(individuo.getIdindividuo()).orElse(null);
        
    }

    @Override
    public List<Individuo> buscarPorNombre(String nombre) {
        return individuoDao.findByNombre(nombre);
    }

    @Override
    public Individuo buscarIndividuoPorId(Long id) {
        return individuoDao.findById(id).orElse(null);
    }
    
}
