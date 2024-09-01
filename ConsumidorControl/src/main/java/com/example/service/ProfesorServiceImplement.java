package com.example.service;

import com.example.model.Profesor;
import com.example.repository.ProfesorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImplement implements IProfesorService{
    
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> listarProfesores() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    @Override
    public void guardar(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    @Override
    public Profesor buscarProfesorPorID(int id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        profesorRepository.deleteById(id);
    }

    @Override
    public List<Profesor> buscarPorNombre(String nombre) {
        return profesorRepository.findByNombre(nombre);

    }
    @Override
    public Profesor buscarPorCorreo(String correo) { 
        return profesorRepository.findByCorreo(correo);
    }

    
}
