package com.example.service;

import com.example.model.Asistencia;
import java.util.List;

public interface IAsistenciaService {
    List<Asistencia> listarAsistencias();
    void guardarAsistencia(Asistencia asistencia);
    void eliminarAsistencia(int id);
    Asistencia buscarAsistenciaPorId(int id);
}
