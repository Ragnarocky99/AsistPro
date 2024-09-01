package com.example.service;

import com.example.model.Asistencia;
import com.example.model.Horario;
import com.example.repository.AsistenciaRepository;
import java.time.LocalDate;
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

    @Override
    public Asistencia buscarAsistenciaPorFechaYHorario(LocalDate fecha, Horario horario) {
        return asisRepo.findByFechaAndHorario(fecha, horario);
    }

    @Override
    public List<Asistencia> buscarAsistenciasDelCurso(LocalDate fecha, int idespecialidad, String curso, int seccion) {
        return asisRepo.findAsistenciasByFechaEspecialidadCursoSeccion(fecha, idespecialidad, curso, seccion);
    }
    
}
