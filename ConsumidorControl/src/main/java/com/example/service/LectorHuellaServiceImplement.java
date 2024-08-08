package com.example.service;

import com.example.model.LectorHuella;
import com.example.repository.LectorHuellaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LectorHuellaServiceImplement implements ILectorHuellaService{
    
    @Autowired
    private LectorHuellaRepository lectorRepo;

    @Override
    public List<LectorHuella> listarLectores() {
        return lectorRepo.findAll();
    }

    @Override
    public void guardarLector(LectorHuella lector) {
        lectorRepo.save(lector);
    }

    @Override
    public void borrarLector(int id) {
        lectorRepo.deleteById(id);
    }

    @Override
    public LectorHuella buscarLector(int id) {
        return lectorRepo.findById(id).orElse(null);
    }
    
}
