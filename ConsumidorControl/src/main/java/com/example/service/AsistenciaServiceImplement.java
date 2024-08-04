package com.example.service;

import com.example.model.Asistencia;
import com.example.repository.AsistenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImplement implements IAsistenciaService{
    
    @Autowired
    private AsistenciaRepository asisRepo;

    @Override
    public List<Asistencia> listarAsistencias() {
        return asisRepo.findAll();
    }

    @Override
    public void guardarAsistencia(Asistencia asistencia) {
        asisRepo.save(asistencia);
    }

    @Override
    public void eliminarAsistencia(int id) {
        asisRepo.deleteById(id);
    }

    @Override
    public Asistencia buscarAsistenciaPorId(int id) {
        return asisRepo.findById(id).orElse(null);
    }
    
}
