package com.example.service;

import com.example.model.Materia;
import com.example.repository.MateriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MateriaServiceImplement implements IMateriaService{
    
    @Autowired
    private MateriaRepository materiaRepo;

    @Override
    public List<Materia> listarMaterias() {
        return materiaRepo.findAll();
    }

    @Override
    public void eliminarMateria(int id) {
        materiaRepo.deleteById(id);
    }

    @Override
    public void guardarMateria(Materia materia) {
        materiaRepo.save(materia);
    }

    @Override
    public Materia buscarMateriaPorId(int id) {
        return materiaRepo.findById(id).orElse(null);
    }
}
